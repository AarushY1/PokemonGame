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

    public Trainer(String name, Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3, Pokemon pokemon4, Pokemon pokemon5, Pokemon pokemon6)
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
        System.out.print("1 - Switch | 2 - Attack | 3 - Use Item ");
        int choice = console.nextInt();
        return choice;
   }

   public void switchPokemon()
   {
        Scanner console = new Scanner(System.in);    
        System.out.print("Enter a number for which pokemon \n Pokemon 1: " + this.pokemon1.name + "\n Pokemon 2: " + this.pokemon2.name + "\n Pokemon 3: " + this.pokemon3.name + "\n Pokemon 4: " + this.pokemon4.name + "\n Pokemon 5: " + this.pokemon5.name + "\n Pokemon 6: " + this.pokemon6.name);
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
            default: System.out.print("Invalid Number");
            
        }
   }
   public void attack(Trainer otherTrainer)
   {
    Scanner console = new Scanner(System.in);
    System.out.print("Enter a number for which pokemon's move \n Move 1: " + this.currentPokemon.move1.name + "\n Move 2: " + this.currentPokemon.move2.name + "\n Move 3: " + this.currentPokemon.move3.name + "\n Move 4: " + this.currentPokemon.move4.name);
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
        otherTrainer.currentPokemon.currentHP -= this.currentPokemon.attack(currentMove);
        if(otherTrainer.currentPokemon.currentHP <= 0)
        {
            otherTrainer.currentPokemon.currentHP = 0;
            otherTrainer.switchPokemon();
        }
    }
    
    public static void main(String[] args)
    {
        Trainer Trainer1 = new Trainer("Gary", null, null, null, null, null, null );
        Trainer Trainer2 = new Trainer("Bob", null, null, null, null, null, null );
        
        Trainer1.switchPokemon();
    }
}

/*HW 4/30/2023
 * in turn method, don't break if not typed 1,2,3
 * also for switch method(ask again if not typed 1-6)
 * Add pokemon trainers to test out
 * In the battle method make 2 trainers pokemon that have real moves
 */
