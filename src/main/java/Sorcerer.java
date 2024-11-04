import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Sorcerer implements Hero {
    private String name;
    private double mana;
    private double strength;
    private double agility;
    private double dexterity;
    private double Gold;
    private double level;
    private double Hp;
    private double Xp;
    private HashMap<String, Object> Inventory;
    private String type;
    private int empty_hand;

    public Sorcerer(String name, int mana, int strength, int agility, int dexterity, int Gold, int level, String type) {
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

    public Sorcerer(ArrayList<Object> attributes) {
        this.name = (String) attributes.get(0);
        this.mana = (double) attributes.get(1);
        this.strength = (double) attributes.get(2);
        this.agility = (double) attributes.get(3);
        this.dexterity = (double) attributes.get(4);
        this.Gold = (int) attributes.get(5);
        this.level = (int) attributes.get(6);
        this.type = (String) attributes.get(7);
        this.Hp = level * 100;
        this.Xp = 0;
        this.Inventory = new HashMap<String, Object>();
        this.empty_hand = 2;
    }

    public String getName() { return name; }
    public double getMana() { return mana; }
    public double getStrength() { return strength; }
    public double getAgility() { return agility; }
    public double getDexterity() { return dexterity; }
    public double getGold() { return Gold; }
    public double getLevel() { return level; }
    public double getHp() { return Hp; }
    public double getXp() { return Xp; }
    public HashMap<String, Object> getInventory() { return Inventory; }
    public String getType() { return type; }
    public int getEmpty_hand() { return empty_hand; }


    public void setName(String name) { this.name = name; }
    public void setMana(double mana) { this.mana = mana; }
    public void setStrength(double strength) { this.strength = strength; }
    public void setAgility(double agility) { this.agility = agility; }
    public void setDexterity(double dexterity) { this.dexterity = dexterity; }
    public void setGold(double Gold) { this.Gold = Gold; }
    public void setLevel(double level) { this.level = level; }
    public void setHp(double Hp) { this.Hp = Hp; }
    public void setXp(double Xp) { this.Xp = Xp; }
    public void setInventory(HashMap<String, Object> Inventory) { this.Inventory = Inventory; }
    public void setType(String type) { this.type = type; }
    public void setEmpty_hand(int empty_hand) { this.empty_hand = empty_hand; }

    public void levelUp() {
        this.level++;
        this.Hp = this.level * 100;
        this.strength = (double) Math.round(this.mana * 1.05 * 100) / 100;
        this.agility = (double) Math.round(this.strength * 1.1 * 100) / 100;
        this.dexterity = (double) Math.round(this.strength * 1.1 * 100) / 100;
        this.mana = (double) Math.round(this.mana * 1.05 * 100) / 100;
        this.Xp = 0;
    }

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

    public JSONObject toJSON() {
        JSONObject hero = new JSONObject();
        hero.put("name", this.name);
        hero.put("mana", this.mana);
        hero.put("strength", this.strength);
        hero.put("agility", this.agility);
        hero.put("dexterity", this.dexterity);
        hero.put("Gold", this.Gold);
        hero.put("level", this.level);
        hero.put("type", this.type);
        hero.put("Hp", this.Hp);
        hero.put("Xp", this.Xp);
        hero.put("Inventory", this.Inventory);
        hero.put("empty_hand", this.empty_hand);
        return hero;
    }

    public void addInventory(String item_name, Object item) {
        this.Inventory.put(item_name, item);
    }

}
