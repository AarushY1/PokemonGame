public class Pokemon
  {
    private String name;
    private int level;
    private String type;
    private int maxHP;
    private int currentHP;
    private int attack;
    private int defense;

    public Pokemon(String name, int level, String type, int maxHP, int currentHP, int attack, int defense)
    {
      this.name = name;
      this.level = level;
      this.type = type;
      this.maxHP = maxHP;
      this.currentHP = currentHP;
      this.attack = attack;
      this.defense = defense;
    }
    public static void main(String[] args)
    {
      
      
    Pokemon x = new Pokemon("Pikachu", 5, "Electric", 35, 35, 5, 5);
    
    String name = x.getName();
    System.out.println(name);

    int level = x.getLevel();
    System.out.println(level);

    String type = x.getType();
    System.out.println(type);

    int maxHP = x.getMaxHP();
    System.out.println(maxHP);

    int CurrentHP = x.getCurrentHP();
    System.out.println(CurrentHP);

    int Attack = x.getAttack();
    System.out.println(Attack);

    int Defense = x.getDefense();
    System.out.println(Defense);


    }

    public void levelUp()
    {
      this.level += 1;
      System.out.print(this.name + " has leveled up to " + this.level);
    }

    public String getName()
    {
      return this.name;
    }

    public void setName(String name)
    {
      this.name = name;
    }

    public int getLevel() {
      return this.level;
    }
  
    public void setLevel(int level) {
      this.level = level;
    }
  
    public String getType() {
      return this.type;
    }
  
    public void setType(String type) {
      this.type = type;
    }
  
    public int getMaxHP() {
      return this.maxHP;
    }
  
    public void setMaxHP(int maxHP) {
      this.maxHP = maxHP;
    }
  
    public int getCurrentHP() {
      return this.currentHP;
    }
  
    public void setCurrentHP(int currentHP) {
      this.currentHP = currentHP;
    }
  
    public int getAttack() {
      return this.attack;
    }
  
    public void setAttack(int attack) {
      this.attack = attack;
    }
  
    public int getDefense() {
      return this.defense;
    }
  
    public void setDefense(int defense) {
      this.defense = defense;
    }
  }
  //HW
  /*
   * Add attributes
   * getters and setters
   * 
   */