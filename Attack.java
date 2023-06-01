public class Attack 
{
    String name;
    String type;
    int power;
    int accuracy;
    String description;

    public Attack(String name, String type, int power, int accuracy, String description) 
    {
        this.name = name;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
        this.description = description;
    }

    public String toString() 
    {
        return name + " (" + type + "): " + description + " Power: " + power + " Accuracy: " + accuracy;
    }

    public static void main (String[] args)
    {
        ;
        
    }
}
