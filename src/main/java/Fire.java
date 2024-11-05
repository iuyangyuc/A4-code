import java.util.ArrayList;

public class Fire implements Spell {

    private String name;
    private int cost;
    private int requiredLevel;
    private int damage;
    private int manaCost;
    private int usage;

    public Fire(String name, int cost, int requiredLevel, int damage, int manaCost, int usage) {
        this.name = name;
        this.cost = cost;
        this.requiredLevel = requiredLevel;
        this.damage = damage;
        this.manaCost = manaCost;
        this.usage = usage;
    }

    public Fire(ArrayList<Object> attribute) {
        this.name = (String) attribute.get(0);
        this.cost = (int) attribute.get(1);
        this.requiredLevel = (int) attribute.get(2);
        this.damage = (int) attribute.get(3);
        this.manaCost = (int) attribute.get(4);
        this.usage = (int) attribute.get(6);
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }

    public String toString() {
        return "Spell{Name: " + name + ", Cost: " + cost + ", Required Level: " + requiredLevel + ", Damage: " + damage + ", Mana Cost: " + manaCost + ", Usage: " + usage + "}";
    }

    public String getEffectField() {
        return "defence";
    }
}
