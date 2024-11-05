import java.util.ArrayList;

public interface Spell {
    String getEffectField();
    int getUsage();
    int getManaCost();
    int getDamage();
    int getRequiredLevel();
    int getCost();
    String getName();

    void setUsage(int usage);
}
