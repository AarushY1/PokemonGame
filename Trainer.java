import java.util.*;
public class Trainer 
{
    String name;
    Pokemon pokemon1;
    Pokemon pokemon2;
    Pokemon pokemon3;
    Pokemon pokemon4;
    Pokemon pokemon5;
    Pokemon pokemon6;
    Pokemon[] pokemon;
    Pokemon currentPokemon;
    ArrayList<Item> items;

    public Trainer(String name, Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3, Pokemon pokemon4, Pokemon pokemon5, Pokemon pokemon6, ArrayList<Item> items)
    {
        this.name = name;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.pokemon3 = pokemon3;
        this.pokemon4 = pokemon4;
        this.pokemon5 = pokemon5;
        this.pokemon6 = pokemon6;
        this.pokemon = new Pokemon[]{pokemon1, pokemon2, pokemon3, pokemon4, pokemon5, pokemon6};
        this.currentPokemon = pokemon1;
        this.items = items;
    }

   public boolean allPokemonDead()
   {
        for(int i = 0; i < 6; i++)
        {
            if(this.pokemon[i].currentHP > 0)
            {
                return false;
            } 
            
        }
        return true;
   } 

   public int turn() 
   {
        Scanner console = new Scanner(System.in);
        int choice;
        do 
        {
            System.out.print(this.name + " 1 - Switch | 2 - Attack | 3 - Use Item: ");
            choice = console.nextInt();
        } 
        while (choice < 1 || choice > 3);
        return choice;
    }

   public void switchPokemon()
   {
        Pokemon[] allPokemon = new Pokemon[]{this.pokemon1, this.pokemon2, this.pokemon3, this.pokemon4, this.pokemon5, this.pokemon6};
        Scanner console = new Scanner(System.in);    
        System.out.println("Enter a number for which pokemon");
        for(int i = 0; i < 6; i++)
        {
            if(allPokemon[i].currentHP > 0)
            {
               System.out.println("Pokemon " + (i+1) + " is " + this.pokemon[i].name); 
            }
        }
        
        int numPokemon = console.nextInt();
        switch(numPokemon)
        {
            case 1: currentPokemon = pokemon1;
                break;
            case 2: currentPokemon = pokemon2;
                break;
            case 3: currentPokemon = pokemon3;
                break; 
            case 4: currentPokemon = pokemon4;
                break;
            case 5: currentPokemon = pokemon5;
                break;  
            case 6: currentPokemon = pokemon6;
                break;
            default: System.out.println("Invalid Number");
            
        }
   }
   public void attack(Trainer otherTrainer)
   {
    Scanner console = new Scanner(System.in);
    System.out.println("Enter a number for " + this.currentPokemon.name + " move \n Move 1: " + this.currentPokemon.move1.name + " - " + this.currentPokemon.move1.power + "\n Move 2: " + this.currentPokemon.move2.name + " - " + this.currentPokemon.move2.power + "\n Move 3: " + this.currentPokemon.move3.name + " - " + this.currentPokemon.move3.power + "\n Move 4: " + this.currentPokemon.move4.name + " - " + this.currentPokemon.move4.power);
    int moveNumber = console.nextInt();

    Attack currentMove = null;
    switch(moveNumber)
        {
            case 1: currentMove = this.currentPokemon.move1;
                break;
            case 2: currentMove = this.currentPokemon.move2;
                break;
            case 3: currentMove = this.currentPokemon.move3;
                break; 
            case 4: currentMove = this.currentPokemon.move4;
                break;
            default: System.out.print("Invalid Number");
        }
        double m = multiplier(this.currentPokemon, otherTrainer.currentPokemon, currentMove);
        System.out.println();
        //System.out.println(m);
        double damage = m * (this.currentPokemon.attack / otherTrainer.currentPokemon.defense) * this.currentPokemon.attack(currentMove) + 2;
        //System.out.println(damage); 
        otherTrainer.currentPokemon.currentHP -= (int)damage;
        System.out.println( this.currentPokemon.name + " used " + currentMove.name + " on " + otherTrainer.currentPokemon.name);
         
        if(otherTrainer.currentPokemon.currentHP <= 0)
        {
            otherTrainer.currentPokemon.currentHP = 0;
            System.out.println(otherTrainer.currentPokemon.name + " has fainted!");
            if(!otherTrainer.allPokemonDead())
            {
                otherTrainer.switchPokemon();
            }
        }
        System.out.println(otherTrainer.currentPokemon.name + " now has " + otherTrainer.currentPokemon.currentHP + " HPs left");
    }

    public void useItem()
    {
        
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the number of the item you want to use:");
        int index = 1;
        for (Item item : this.items) {
            System.out.println("Item " + index + ": " + item.getName());
            index++;
        }
        int itemNumber = console.nextInt();
        Item chosenItem = this.items.get(itemNumber -1);
        this.currentPokemon.currentHP += chosenItem.getQuantity();

        if(this.currentPokemon.currentHP >= this.currentPokemon.maxHP)
        {
            this.currentPokemon.currentHP = this.currentPokemon.maxHP;
        }
        System.out.println("Trainer " + this.name + " used " + chosenItem.getName() + " : " + this.currentPokemon.name + " " + this.currentPokemon.currentHP);

        this.items.remove(itemNumber-1);
        
    }
    
    public static double multiplier(Pokemon p1, Pokemon p2, Attack aMove)
    {
        //When adding different types copy the array and the .put
        double m = 1;
        String p1Type = p1.type;
        String p2Type = p2.type;
        HashMap<String, String[]> superEffective = new HashMap<String, String[]>();
        String[] fire = {"Grass", "Bug", "Steel"};
        superEffective.put("Fire", fire);
        String[] water = {"Ground", "Rock", "Fire"};
        superEffective.put("Water", water);
        String[] dragon = {"Dragon"};
        superEffective.put("dragon", dragon);
        String[] ice = {"Flying", "Ground", "Grass", "Dragon"};
        superEffective.put("Ice", ice);
        String[] fairy = {"Fighting", "Dragon", "Dark"};
        superEffective.put("Fairy", fairy);
        String[] dark = {"Ghost", "Psychic"};
        superEffective.put("Dark", dark);
        String[] psychic = {"Fighting", "Poison"};
        superEffective.put("Psychic", psychic);
        String[] electric = {"Flying", "Water"};
        superEffective.put("Electric", electric);
        String[] grass = {"Ground", "Rock", "Water"};
        superEffective.put("Grass", grass);
        String[] steel = {"Rock", "Ice", "Fairy"};
        superEffective.put("Steel", steel);
        String[] ghost = {"Ghost", "Psychic"};
        superEffective.put("Ghost", ghost);
        String[] bug = {"Grass", "Psychic", "Dark"};
        superEffective.put("Bug", bug);
        String[] rock = {"Flying", "Bug", "Fire", "Ice"};
        superEffective.put("Rock", rock);
        String[] ground = {"Poison", "Rock", "Steel", "Fire", "Electric"};
        superEffective.put("Ground", ground);
        String[] poison = {"Grass", "Fairy"};
        superEffective.put("Poison", poison);
        String[] flying = {"Fighting", "Bug", "Grass"};
        superEffective.put("Flying", flying);
        String[] fighting = {"Normal", "Rock", "Steel", "Ice", "Dark"};
        superEffective.put("Fighting", fighting);
        for(String t: superEffective.get(p1Type))
        {
            if(p2Type == t)
            {
                m *= 2;
            }
        }
        

        HashMap<String, String[]> uneffective = new HashMap<String, String[]>();
        String[] fire1 = {"Rock", "Water", "Fire", "Dragon"};
        uneffective.put("Fire", fire1);
        String[] water1 = {"Water", "Grass", "Dragon"};
        uneffective.put("Water", water1);
        String[] dragon1 = {"Steel", "Fairy"};
        uneffective.put("dragon", dragon1);
        String[] ice1 = {"Steel", "Fire", "Water", "Ice"};
        uneffective.put("Ice", ice1);
        String[] fairy1 = {"Poison", "Steel", "Fire"};
        uneffective.put("Fairy", fairy1);
        String[] dark1 = {"Fighting", "Dark", "Fairy"};
        uneffective.put("Dark", dark1);
        String[] psychic1 = {"Steel", "Psychic", "Dark"};
        uneffective.put("Psychic", psychic1);
        String[] electric1 = {"Ground", "Grass", "Electric", "Dragon"};
        uneffective.put("Electric", electric1);
        String[] grass1 = {"Flying", "Poison", "Bug", "Steel", "Fire", "Grass", "Dragon"};
        uneffective.put("Grass", grass1);
        String[] steel1 = {"Steel", "Fire", "Water", "Electric"};
        uneffective.put("Steel", steel1);
        String[] ghost1 = {"Normal", "Dark"};
        uneffective.put("Ghost", ghost1);
        String[] bug1 = {"Fighting", "Flying", "Poison", "Ghost", "Steel", "Fire", "Fairy"};
        uneffective.put("Bug", bug1);
        String[] rock1 = {"Fighting", "Ground", "Steel"};
        uneffective.put("Rock", rock1);
        String[] ground1 = {"Flying", "Ground", "Steel"};
        uneffective.put("Ground", ground1);
        String[] poison1 = {"Poison", "Ground", "Rock", "Ghost", "Steel"};
        uneffective.put("Poison", poison1);
        String[] flying1 = {"Rock", "Steel", "Electric"};
        uneffective.put("Flying", flying1);
        String[] fighting1 = {"Flying", "Poison", "Psychic", "Bug", "Ghost", "Fairy"};
        uneffective.put("Fighting", fighting1);
        for(String t: uneffective.get(p1Type))
        {
            if(p2Type == t)
            {
                m *= 0.5;
            }
        }

        if(p1Type == aMove.type)
        {
            m *= 1.5;
        }
        return m;
    }
    public static void main(String[] args)
    {
        Trainer Trainer1 = new Trainer("Gary", null, null, null, null, null, null, null );
        Trainer Trainer2 = new Trainer("Bob", null, null, null, null, null, null, null );
        
        Trainer1.switchPokemon();
    }
}

/*HW 5/28/2023
 *  add other types to make supereffective and uneffective
 */
