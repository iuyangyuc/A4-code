import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public interface Hero {
    void levelUp();
    void setName(String name);
    void setMana(double mana);
    void setStrength(double strength);
    void setAgility(double agility);
    void setDexterity(double dexterity);
    void setGold(double Gold);
    void setLevel(double level);
    void setHp(double Hp);
    void setXp(double Xp);
    void setInventory(HashMap<String, Object> Inventory);
    void setType(String type);
    void setEmpty_hand(int empty_hand);
    String getName();
    double getMana();
    double getStrength();
    double getAgility();
    double getDexterity();
    double getGold();
    double getLevel();
    double getHp();
    double getXp();
    HashMap<String, Object> getInventory();
    String getType();
    int getEmpty_hand();
    void addInventory(String item_name, Object item);
    void removeInventory(String item_name);
    void EditWeapon(Weapon weapon, int hand, boolean add);
}
