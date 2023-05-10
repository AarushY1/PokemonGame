
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
            trainer1.switchPokemon();;//switch
        }
        if(trainer2Turn == 1)
        {
            trainer2.switchPokemon();;//switch
        }
        if(trainer1Turn == 2)
        {
            trainer1.attack(trainer2.currentPokemon);//attack
        }
        else if(trainer1Turn == 3)
        {
            trainer1.useItem();//useitem
        }
        if(trainer2Turn == 2)
        {
            trainer2.attack(trainer1.currentPokemon);//attack
        }
        else if(trainer2Turn == 3)
        {
            trainer2.useItem();//useitem
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
        Attack psychic = new Attack("Psychic", "Psychic", 90, 100, "A powerful psychic attack that may lower the foe's Special Defense.");
        Attack shadow_ball = new Attack("Shadow Ball", "Ghost", 80, 100, "A sinister ball of dark energy that may lower the foe's Special Defense.");
        Attack hydro_pump = new Attack("Hydro Pump", "Water", 110, 80, "A high-powered water attack that has a low chance of missing.");
        Attack solar_beam = new Attack("Solar Beam", "Grass", 120, 100, "A two-turn attack that gathers energy on the first turn and unleashes it on the second.");
        Attack thunder = new Attack("Thunder", "Electric", 110, 70, "A powerful electric attack that may paralyze the foe.");
        Attack fire_blast = new Attack("Fire Blast", "Fire", 110, 85, "A powerful fire attack that may burn the foe.");
        Attack ice_punch = new Attack("Ice Punch", "Ice", 75, 100, "A punch of ice that may freeze the foe.");
        Attack sludge_bomb = new Attack("Sludge Bomb", "Poison", 90, 100, "A bomb of sludge that may poison the foe.");
        Attack hypnosis = new Attack("Hypnosis", "Psychic", 0, 60, "Puts the foe into a deep sleep.");
        Attack x_scissor = new Attack("X-Scissor", "Bug", 80, 100, "A powerful scissor-like attack that deals damage.");
        Attack bullet_punch = new Attack("Bullet Punch", "Steel", 60, 100, "A fast and powerful punch that always goes first.");
        Attack swords_dance = new Attack("Swords Dance", "Normal", 0, 0, "Sharply raises the user's Attack stat.");
        Attack roost = new Attack("Roost", "Flying", 0, 0, "Restores the user's HP by half of its max HP while landing on the ground.");
        
        Pokemon charizard = new Pokemon("Charizard", 30, "Fire", 150, 150, 100, 90, 70, thunderbolt, earthquake, flamethrower, ice_beam);
        Pokemon machamp = new Pokemon("Machamp", 30, "Fighting", 130, 130, 120, 100, 60, thunder, earthquake, ice_punch, fire_blast); 
        Pokemon alakazam = new Pokemon("Alakazam", 30, "Psychic", 120, 120, 95, 80, 70, psychic, shadow_ball, hydro_pump, solar_beam);
        Pokemon gyarados = new Pokemon("Gyarados", 30, "Water", 170, 170, 100, 50, 50, thunderbolt, hydro_pump, ice_beam, earthquake);
        Pokemon dragonite = new Pokemon("Dragonite", 30, "Dragon", 170, 170, 120, 100, 90, thunder, fire_blast, ice_beam, earthquake);
        Pokemon typhlosion = new Pokemon("Typhlosion", 35, "Fire", 140, 140, 90, 90, 110, flamethrower, earthquake, shadow_ball, solar_beam);
        Pokemon lapras = new Pokemon("Lapras", 40, "Water", 200, 200, 100, 95, 70, thunderbolt, ice_beam, hydro_pump, psychic);
        Pokemon jolteon = new Pokemon("Jolteon", 35, "Electric", 110, 110, 80, 75, 150, thunderbolt, shadow_ball, ice_beam, thunder);
        Pokemon starmie = new Pokemon("Starmie", 50, "Water", 150, 150, 95, 105, 120, thunderbolt, ice_beam, psychic, hydro_pump);
        Pokemon blastoise = new Pokemon("Blastoise", 55, "Water", 170, 170, 95, 120, 93, hydro_pump, ice_beam, earthquake, psychic);
        Pokemon gengar = new Pokemon("Gengar", 35, "Ghost/Poison", 130, 130, 80, 60, 110, shadow_ball, sludge_bomb, thunderbolt, hypnosis);
        Pokemon scizor = new Pokemon("Scizor", 45, "Bug/Steel", 180, 180, 120, 100, 70, x_scissor, bullet_punch, swords_dance, roost);


        //String name, int level, String type, int maxHP, int currentHP, int attack, int defense, int speed, Attack move1, Attack move2, Attack move3, Attack move4

        Trainer Gary = new Trainer("Gary", charizard, typhlosion, lapras, jolteon, gyarados, scizor);
        Trainer Bob = new Trainer("Bob", alakazam, dragonite, machamp, starmie, blastoise, gengar);
        
    }
}