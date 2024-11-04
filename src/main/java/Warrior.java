import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Hero {
    private String name;
    private int mana;
    private int strength;
    private int agility;
    private int dexterity;
    private int Gold;
    private int level;
    private int Hp;
    private int Xp;
    private HashMap<String, Object> Inventory;
    private String type;
    private int empty_hand;

    public Hero(String name, int mana, int strength, int agility, int dexterity, int Gold, int level, String type) {
        this.name = name;
        this.mana = mana;
        this.strength = strength;
        this.agility = agility;
        this.dexterity = dexterity;
        this.Gold = Gold;
        this.level = level;
        this.Hp = level * 100;
        this.Xp = 0;
        this.Inventory = new HashMap<String, Object>();
        this.type = type;
        this.empty_hand = 2;
    }

    public Hero(ArrayList<Object> attributes) {
        this.name = (String) attributes.get(0);
        this.mana = (int) attributes.get(1);
        this.strength = (int) attributes.get(2);
        this.agility = (int) attributes.get(3);
        this.dexterity = (int) attributes.get(4);
        this.Gold = (int) attributes.get(5);
        this.level = (int) attributes.get(6);
        this.type = (String) attributes.get(7);
        this.Hp = level * 100;
        this.Xp = 0;
        this.Inventory = new HashMap<String, Object>();
        this.empty_hand = 2;
    }

    public String getName() { return name; }
    public int getMana() { return mana; }
    public int getStrength() { return strength; }
    public int getAgility() { return agility; }
    public int getDexterity() { return dexterity; }
    public int getGold() { return Gold; }
    public int getLevel() { return level; }
    public int getHp() { return Hp; }
    public int getXp() { return Xp; }
    public HashMap<String, Object> getInventory() { return Inventory; }


    public void setName(String name) { this.name = name; }
    public void setMana(int mana) { this.mana = mana; }
    public void setStrength(int strength) { this.strength = strength; }
    public void setAgility(int agility) { this.agility = agility; }
    public void setDexterity(int dexterity) { this.dexterity = dexterity; }
    public void setGold(int Gold) { this.Gold = Gold; }
    public void setLevel(int level) { this.level = level; }
    public void setHp(int Hp) { this.Hp = Hp; }
    public void setXp(int Xp) { this.Xp = Xp; }
    public void setInventory(HashMap<String, Object> Inventory) { this.Inventory = Inventory; }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", mana=" + mana +
                ", strength=" + strength +
                ", agility=" + agility +
                ", dexterity=" + dexterity +
                ", Gold=" + Gold +
                ", level=" + level +
                ", Hp=" + Hp +
                ", Xp=" + Xp +
                ", Inventory=" + Inventory +
                ", empty_hand=" + empty_hand +
                '}';
    }
}
