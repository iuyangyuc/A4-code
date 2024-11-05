import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Warrior implements Hero {
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
    private HashMap<String, Object> Equipped;
    private String type;
    private int empty_hand;

    public Warrior(String name, double mana, double strength, double agility, double dexterity, double Gold, double level, String type) {
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
        this.Equipped = new HashMap<String, Object>();
        this.type = type;
        this.empty_hand = 2;
    }

    public Warrior(ArrayList<Object> attributes) {
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
        this.Equipped = new HashMap<String, Object>();
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
    public HashMap<String, Object> getEquipped() { return Equipped; }


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
    public void setEquipped(HashMap<String, Object> Equipped) { this.Equipped = Equipped; }

    public void levelUp() {
        GameUtlity gameUtlity = new GameUtlity();
        this.level++;
        this.Hp = this.level * 100;
        this.strength = gameUtlity.keep2(this.strength * 1.1);
        this.agility = gameUtlity.keep2(this.agility * 1.1);
        this.dexterity = gameUtlity.keep2(this.dexterity * 1.05);
        this.mana = gameUtlity.keep2(this.mana * 1.05);
        this.Xp = 0;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", mana=" + mana +
                ", strength=" + strength +
                ", agility=" + agility +
                ", dexterity=" + dexterity +
                ", Gold=" + Gold +
                ", level=" + level +
                ", Hp=" + Hp +
                ", Xp=" + Xp +
                ", Inventory=" + Inventory +
                ", empty_hand=" + empty_hand;
    }

    public void addInventory(String item_name, Object item) {
        this.Inventory.put(item_name, item);
    }

    public void removeInventory(String item_name) {
        this.Inventory.remove(item_name);
    }

    public void EditWeapon(Weapon weapon, int hand, boolean add) {
        if(add) {
            this.empty_hand -= hand;
            this.strength += weapon.getDamage();
            if(hand == 2) {
                this.strength += weapon.getDamage() * 0.5;
            }
        } else {
            this.empty_hand += hand;
            this.strength -= weapon.getDamage();
            if(hand == 2) {
                this.strength -= weapon.getDamage() * 0.5;
            }
        }
    }

    public void addEquipped(String item_name, Object item) {
        this.Equipped.put(item_name, item);
    }

    public void removeEquipped(String item_name) {
        this.Equipped.remove(item_name);
    }

    public void EditArmor(Armor armor, boolean add) {
        if(add) {
            this.agility += armor.getDefense();
        } else {
            this.agility -= armor.getDefense();
        }
    }

}
