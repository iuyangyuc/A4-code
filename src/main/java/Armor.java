import java.util.ArrayList;

public class Armor {

    private String name;
    private int cost;
    private int requiredLevel;
    private int defense;
    private int usage;
    private int handUsed;

    public Armor(String name, int cost, int requiredLevel, int defense) {
        this.name = name;
        this.cost = cost;
        this.requiredLevel = requiredLevel;
        this.defense = defense;
        this.usage = 10;
        this.handUsed = 0;
    }

    public Armor(ArrayList<Object> attribute) {
        this.name = (String) attribute.get(0);
        this.cost = (int) attribute.get(1);
        this.requiredLevel = (int) attribute.get(2);
        this.defense = (int) attribute.get(3);
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

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
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
        return "Armor{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", requiredLevel=" + requiredLevel +
                ", defense=" + defense +
                '}';
    }
}
