import java.util.ArrayList;

public class Weapon {

    private String name;
    private int cost;
    private int requiredLevel;
    private int damage;
    private int requiredHands;
    private int usage;
    private int handUsed;

    public Weapon(String name, int cost, int requiredLevel, int damage, int requiredHands) {
        this.name = name;
        this.cost = cost;
        this.requiredLevel = requiredLevel;
        this.damage = damage;
        this.requiredHands = requiredHands;
        this.usage = 10;
        this.handUsed = 0;
    }

    public Weapon(ArrayList<Object> attribute) {
        this.name = (String) attribute.get(0);
        this.cost = (int) attribute.get(1);
        this.requiredLevel = (int) attribute.get(2);
        this.damage = (int) attribute.get(3);
        this.requiredHands = (int) attribute.get(4);
        this.usage = 10;
        this.handUsed = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRequiredHands() {
        return requiredHands;
    }

    public void setRequiredHands(int requiredHands) {
        this.requiredHands = requiredHands;
    }

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }

    public int getHandUsed() {
        return handUsed;
    }

    public void setHandUsed(int handUsed) {
        this.handUsed = handUsed;
    }

    @Override
    public String toString() {
        return "Weapon{name='" + name + '\'' +
                ", cost=" + cost +
                ", requiredLevel=" + requiredLevel +
                ", damage=" + damage +
                ", requiredHands=" + requiredHands +
                '}';
    }
}
