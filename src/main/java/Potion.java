import java.util.ArrayList;

public class Potion {

    private String name;
    private int cost;
    private int requiredLevel;
    private int increaseValue;
    private ArrayList<Object> attribute;
    private int usage;

    public Potion(String name, int cost, int requiredLevel, int increaseValue, ArrayList<Object> attribute, int usage) {
        this.name = name;
        this.cost = cost;
        this.requiredLevel = requiredLevel;
        this.increaseValue = increaseValue;
        this.attribute = attribute;
        this.usage = usage;
    }

    public Potion(ArrayList<Object> attribute) {
        this.name = (String) attribute.get(0);
        this.cost = (int) attribute.get(1);
        this.requiredLevel = (int) attribute.get(2);
        this.increaseValue = (int) attribute.get(3);
        this.attribute = (ArrayList<Object>) attribute.get(4);
        this.usage = (int) attribute.get(5);
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public int getIncreaseValue() {
        return increaseValue;
    }

    public ArrayList<Object> getAttribute() {
        return attribute;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public void setIncreaseValue(int increaseValue) {
        this.increaseValue = increaseValue;
    }

    public void setAttribute(ArrayList<Object> attribute) {
        this.attribute = attribute;
    }

    public String toString() {
        return "Name: " + name + ", Cost: " + cost + ", Required Level: " + requiredLevel + ", Increase Value: " + increaseValue + ", Attribute: " + attribute + ", Usage: " + usage;
    }

}
