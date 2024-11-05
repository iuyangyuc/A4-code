public interface Monster {
    void levelUp(int increase);
    String getName();
    int getLevel();
    double getHp();
    double getDamage();
    double getDefense();
    double getDodgeChance();

    void setHp(double hp);
    void setDamage(double damage);
    void setDefense(double defense);
    void setDodgeChance(double dodgeChance);
    void setLevel(int level);
    void setName(String name);
}
