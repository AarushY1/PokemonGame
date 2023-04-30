
import java.util.*;
public class Battle 
{
    private Trainer trainer1;
    private Trainer trainer2;
    

    public Battle(Trainer trainer1, Trainer trainer2)
    {
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
        if(trainer1.currentPokemon.speed > trainer2.currentPokemon.speed)
        {
            this.trainer1 = trainer1;
            this.trainer2 = trainer2;
        }
        else if(trainer1.currentPokemon.speed < trainer2.currentPokemon.speed)
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
        int trainer1Turn = trainer1.turn();
        int trainer2Turn = trainer2.turn();
            
        if(trainer1Turn == 1)
        {
            ;//switch
        }
        if(trainer2Turn == 1)
        {
            ;//switch
        }
        if(trainer1Turn == 2)
        {
            ;//attack
        }
        else if(trainer1Turn == 3)
        {
            ;//useitem
        }
        if(trainer2Turn == 2)
        {
            ;//attack
        }
        else if(trainer2Turn == 3)
        {
            ;//useitem
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
        Attack thunderbolt = new Attack("Thunderbolt", "Electric", 90, 100, "A strong electric attack that may paralyze the foe.");
        Attack flamethrower = new Attack("Flamethrower", "Fire", 95, 100, "A powerful fire attack that may burn the foe.");
        Attack earthquake = new Attack("Earthquake", "Ground", 100, 100, "A mighty earthquake that strikes all Pokémon in battle, including the user.");
        Attack ice_beam = new Attack("Ice Beam", "Ice", 90, 100, "A cold beam of ice that may freeze the foe.");
        
        Pokemon charizard1 = new Pokemon("Charizard", 25, "Fire", 120, 120, 90, 80, 50, thunderbolt, earthquake, flamethrower, ice_beam);
        Pokemon charizard2 = new Pokemon("Charizard", 25, "Fire", 120, 120, 90, 80, 50, thunderbolt, earthquake, flamethrower, ice_beam);
        Pokemon charizard3 = new Pokemon("Charizard", 25, "Fire", 120, 120, 90, 80, 50, thunderbolt, earthquake, flamethrower, ice_beam);
        Pokemon charizard4 = new Pokemon("Charizard", 25, "Fire", 120, 120, 90, 80, 50, thunderbolt, earthquake, flamethrower, ice_beam);
        Pokemon charizard5 = new Pokemon("Charizard", 25, "Fire", 120, 120, 90, 80, 50, thunderbolt, earthquake, flamethrower, ice_beam);
        Pokemon charizard6 = new Pokemon("Charizard", 25, "Fire", 120, 120, 90, 80, 50, thunderbolt, earthquake, flamethrower, ice_beam);
        System.out.println(thunderbolt);
        //String name, int level, String type, int maxHP, int currentHP, int attack, int defense, int speed, Attack move1, Attack move2, Attack move3, Attack move4

        Trainer Gary = new Trainer("Gary", charizard1, charizard2, charizard3, charizard4, charizard5, charizard6);
        Trainer Bob = new Trainer("Bob", charizard1, charizard2, charizard3, charizard4, charizard5, charizard6);
        
    }
}