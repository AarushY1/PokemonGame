import java.util.*;
public class Trainer 
{
    private String name;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;
    private Pokemon pokemon4;
    private Pokemon pokemon5;
    private Pokemon pokemon6;

    public Trainer(String name, Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3, Pokemon pokemon4, Pokemon pokemon5, Pokemon pokemon6)
    {
        this.name = name;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.pokemon3 = pokemon3;
        this.pokemon4 = pokemon4;
        this.pokemon5 = pokemon5;
        this.pokemon6 = pokemon6;
    }

    public void battle(Trainer otherTrainer)
    {
        System.out.print(this.name + " is battling " + otherTrainer.name);
        Random rand = new Random();
        double num = rand.nextDouble();
        int order = 1; 
        if(num < 0.5)
        {
            order = 1;
        }
        else
        {
            order = 0;
        }
    }
    
    public static void main(String[] args)
    {
        Trainer Trainer1 = new Trainer("Gary", null, null, null, null, null, null );
        Trainer Trainer2 = new Trainer("Bob", null, null, null, null, null, null );
        Trainer1.battle(Trainer2);

    }
}

/*HW 4/16/2023
 * Attack Class get all info about the move
 * Every pokemon have 4 moves
 * 
 */
