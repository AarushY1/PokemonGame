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
    public static void main(String[] args)
    {
        Trainer Trainer1 = new Trainer("Gary", null, null, null, null, null, null );
        Trainer Trainer2 = new Trainer("Bob", null, null, null, null, null, null );
        

    }
}

/*HW 4/16/2023
 * Attack Class get all info about the move
 * Every pokemon have 4 moves
 * 
 */
