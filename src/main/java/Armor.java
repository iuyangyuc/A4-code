import java.util.ArrayList;

public class Armor {

    private String name;
    private int cost;
    private int requiredLevel;
    private int defense;

    public Armor(String name, int cost, int requiredLevel, int defense) {
        this.name = name;
        this.cost = cost;
        this.requiredLevel = requiredLevel;
        this.defense = defense;
    }

    public Armor(ArrayList<Object> attribute) {
        this.name = (String) attribute.get(0);
        this.cost = (int) attribute.get(1);
        this.requiredLevel = (int) attribute.get(2);
        this.defense = (int) attribute.get(3);
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