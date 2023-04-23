
import java.util.*;
public class Battle 
{
    private Trainer trainer1;
    private Trainer trainer2;
    

    public Battle(Trainer trainer1, Trainer trainer2)
    {
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
        if(trainer1.pokemon1.speed > trainer2.pokemon1.speed)
        {
            this.trainer1 = trainer1;
            this.trainer2 = trainer2;
        }
        else if(trainer1.pokemon1.speed < trainer2.pokemon1.speed)
        {
            this.trainer2 = trainer1;
            this.trainer1 = trainer2;
        }
        else
        {
            Random rand = new Random();
            double num = rand.nextDouble();
             
            if(num < 0.5)
            {
                
                this.trainer1 = trainer1;
                this.trainer2 = trainer2;
            }
            else
            {
               
                this.trainer2 = trainer1;
                this.trainer1 = trainer2;
            }
        }
    }

    public void playGame()
    {
        while(!trainer1.allPokemonDead() && !trainer2.allPokemonDead())
        {
           int trainer1Choice = trainer1.turn();
           int trainer2Choice = trainer2.turn();
           if(trainer2Choice > trainer1Choice)
           {
                ; // trainer 2 goes first
           }
           else
           {
                ; // trainer 1 goes first
           }
        }
    }

    public static void main(String[] args)
    {
        

    }
}