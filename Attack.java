public class Attack 
{
    private String name;
    private String type;
    private int power;
    private int accuracy;
    private String description;

    public Attack(String name, String type, int power, int accuracy, String description) 
    {
        this.name = name;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
        this.description = description;
    }

    public String getName() 
    {
        return name;
    }

    public String getType() 
    {
        return type;
    }

    public int getPower() 
    {
        return power;
    }

    public int getAccuracy() 
    {
        return accuracy;
    }

    public String getDescription() 
    {
        return description;
    }

    public String toString() 
    {
        return name + " (" + type + "): " + description + " Power: " + power + " Accuracy: " + accuracy;
    }

    public static void main (String[] args)
    {
        Attack thunderbolt = new Attack("Thunderbolt", "Electric", 90, 100, "A strong electric attack that may paralyze the foe.");
        Attack flamethrower = new Attack("Flamethrower", "Fire", 95, 100, "A powerful fire attack that may burn the foe.");
        Attack earthquake = new Attack("Earthquake", "Ground", 100, 100, "A mighty earthquake that strikes all Pokémon in battle, including the user.");
        Attack ice_beam = new Attack("Ice Beam", "Ice", 90, 100, "A cold beam of ice that may freeze the foe.");
        
        //Pokemon charizard = new Pokemon("Charizard", 120, "Fire", thunderbolt, earthquake, flamethrower, ice_beam);
        System.out.println(thunderbolt);
        
    }
}
