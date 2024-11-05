import java.util.ArrayList;

public class Dragon implements Monster {

    GameUtlity gameUtlity = new GameUtlity();

    private String name;
    private int level;
    private double hp;
    private double damage;
    private double defense;
    private double dodgeChance;

    public Dragon(String name, int level, double hp, double damage, double defense, double dodgeChance) {
        this.name = name;
        this.level = level;
        this.hp = level * 100;
        this.damage = damage;
        this.defense = defense;
        this.dodgeChance = dodgeChance;
    }

    public Dragon(ArrayList<Object> attributes) {
        this.name = (String) attributes.get(0);
        this.level = (int) attributes.get(1);
        this.hp = level * 100;
        this.damage = (int) attributes.get(2);
        this.defense = (int) attributes.get(3);
        this.dodgeChance = (int) attributes.get(4);
    }

    public String getName() { return name; }
    public int getLevel() { return level; }
    public double getHp() { return hp; }
    public double getDamage() { return damage; }
    public double getDefense() { return defense; }
    public double getDodgeChance() { return dodgeChance; }

    public void setHp(double hp) { this.hp = hp; }
    public void setDamage(double damage) { this.damage = damage; }
    public void setDefense(double defense) { this.defense = defense; }
    public void setDodgeChance(double dodgeChance) { this.dodgeChance = dodgeChance; }
    public void setLevel(int level) { this.level = level; }
    public void setName(String name) { this.name = name; }

    public void levelUp(int increase) {
        this.level += increase;
        this.hp = level * 100;
        this.damage += gameUtlity.keep2(this.damage * Math.pow(1.1, increase));
        this.defense += gameUtlity.keep2(this.defense * Math.pow(1.05, increase));
        this.dodgeChance += gameUtlity.keep2(this.dodgeChance * Math.pow(1.05, increase));
    }

    @Override
    public String toString() {
        return "Dragon{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", hp=" + hp +
                ", damage=" + damage +
                ", defense=" + defense +
                ", dodgeChance=" + dodgeChance +
                '}';
    }
}
