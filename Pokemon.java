public class Pokemon
  {
    String name;
    int level;
    String type;
    int maxHP;
    int currentHP;
    int attack;
    int defense;
    int speed;
    Attack[] moves;
    Attack move1;
    Attack move2;
    Attack move3;
    Attack move4;

    

    public Pokemon(String name, int level, String type, int maxHP, int currentHP, int attack, int defense, int speed, Attack move1, Attack move2, Attack move3, Attack move4)
    {
      this.name = name;
      this.level = level;
      this.type = type;
      this.maxHP = maxHP;
      this.currentHP = currentHP;
      this.attack = attack;
      this.defense = defense;
      this.speed = speed;
      this.moves = new Attack[]{move1, move2, move3, move4};
      this.move1 = move1;
      this.move2 = move2;
      this.move3 = move3;
      this.move4 = move4;

    }

    public int attack(Attack move)
    {
      return move.power;
    }
    public static void main(String[] args)
    {
      System.out.print("Test");   
    }

    
  }
  //HW
  /*
   * Add attributes
   * getters and setters
   * 
   */