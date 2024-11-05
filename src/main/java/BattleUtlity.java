import java.util.ArrayList;
import java.util.List;

public class BattleUtlity {

    public void equipWeapon(Hero hero, String weapon_name, int hand){
        if(hero.getInventory().containsKey(weapon_name)){
            if(hero.getInventory().get(weapon_name) instanceof Weapon){
                Weapon weapon = (Weapon) hero.getInventory().get(weapon_name);
                if(hero.getEmpty_hand() >= hand || hero.getEmpty_hand() < weapon.getRequiredHands()){
                    hero.EditWeapon(weapon, hand, true);
                    hero.removeInventory(weapon_name);
                    hero.addEquipped(weapon_name, weapon);
                }
                else{
                    System.out.println("Not enough empty hands");
                }
            }
            else{
                System.out.println("This is not a weapon");
            }
        }
        else{
            System.out.println("This weapon is not in the inventory");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Hero: ").append(hero.getName()).append(" equipped weapon: ").append(weapon_name).append(" in hand: ").append(hand);
        System.out.println(sb);
    }

    public void unEquipWeapon(Hero hero, String weapon_name, int hand){
        if(hero.getEquipped().containsKey(weapon_name) || hero.getEmpty_hand() + hand > 2){
            if(hero.getInventory().get(weapon_name) instanceof Weapon){
                Weapon weapon = (Weapon) hero.getInventory().get(weapon_name);
                hero.EditWeapon(weapon, hand, false);
                hero.removeEquipped(weapon_name);
                hero.addInventory(weapon_name, weapon);
            }
            else{
                System.out.println("This is not a weapon");
            }
        }
        else{
            System.out.println("Wrong hand or weapon name");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Hero: ").append(hero.getName()).append(" unequipped weapon: ").append(weapon_name).append(" from hand: ").append(hand);
        System.out.println(sb);
    }

    public void equipArmor(Hero hero, String armor_name){
        if(hero.getInventory().containsKey(armor_name)){
            if(hero.getInventory().get(armor_name) instanceof Armor){
                Armor armor = (Armor) hero.getInventory().get(armor_name);
                hero.EditArmor(armor, true);
                hero.removeInventory(armor_name);
                hero.addEquipped(armor_name, armor);
            }
            else{
                System.out.println("This is not an armor");
            }
        }
        else{
            System.out.println("This armor is not in the inventory");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Hero: ").append(hero.getName()).append(" equipped armor: ").append(armor_name);
        System.out.println(sb);
    }

    public void unEquipArmor(Hero hero, String armor_name){
        if(hero.getEquipped().containsKey(armor_name)){
            if(hero.getInventory().get(armor_name) instanceof Armor){
                Armor armor = (Armor) hero.getInventory().get(armor_name);
                hero.EditArmor(armor, false);
                hero.removeEquipped(armor_name);
                hero.addInventory(armor_name, armor);
            }
            else{
                System.out.println("This is not an armor");
            }
        }
        else{
            System.out.println("This armor is not in the inventory");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Hero: ").append(hero.getName()).append(" unequipped armor: ").append(armor_name);
    }

    public void usePotion(Hero hero, String potion_name){
        minusUsage(hero, potion_name);
        if(hero.getInventory().containsKey(potion_name)){
            if(hero.getInventory().get(potion_name) instanceof Potion){
                Potion potion = (Potion) hero.getInventory().get(potion_name);
                //hero.removeInventory(potion_name);
                ArrayList<Object> l = potion.getAttribute();
                for(Object o : l){
                    if(o instanceof String){
                        if(o.equals("Health")){
                            hero.setHp(hero.getHp() + potion.getIncreaseValue());
                        }
                        else if(o.equals("Strength")){
                            hero.setStrength(hero.getStrength() + potion.getIncreaseValue());
                        }
                        else if(o.equals("Mana")){
                            hero.setMana(hero.getMana() + potion.getIncreaseValue());
                        }
                        else if(o.equals("Agility")){
                            hero.setAgility(hero.getAgility() + potion.getIncreaseValue());
                        }
                        else if(o.equals("Dexterity")){
                            hero.setDexterity(hero.getDexterity() + potion.getIncreaseValue());
                        }
                    }
                }
            }
            else{
                System.out.println("This is not a potion");
            }
        }
        else{
            System.out.println("This potion is not in the inventory");
        }
        StringBuilder sb = new StringBuilder();
        Potion potion = (Potion) hero.getInventory().get(potion_name);
        sb.append("Hero: ").append(hero.getName()).append(" used potion: ").append(potion_name);
        sb.append(" with attributes:");
        for(Object o : potion.getAttribute()){
            sb.append(" ").append(o);
        }
        sb.append(" and increase value: ").append(potion.getIncreaseValue());
        System.out.println(sb);
    }

    public void useSpell(Hero hero, String spell_name, Monster monster){
        minusUsage(hero, spell_name);
        if(hero.getInventory().containsKey(spell_name)){
            if(hero.getInventory().get(spell_name) instanceof Spell){
                Spell spell = (Spell) hero.getInventory().get(spell_name);
                //hero.removeInventory(spell_name);
                monster.setHp(monster.getHp() - spell.getDamage() * hero.getDexterity() * 0.001 - spell.getDamage());
            }
            else{
                System.out.println("This is not a spell");
            }
        }
        else{
            System.out.println("This spell is not in the inventory");
        }
        StringBuilder sb = new StringBuilder();
        Spell spell = (Spell) hero.getInventory().get(spell_name);
        sb.append("Hero: ").append(hero.getName()).append(" used spell: ").append(spell_name);
        sb.append(" on monster: ").append(monster.getName()).append(" with damage: ").append(spell.getDamage());
        System.out.println(sb);
    }

    public void minusUsage(Hero hero, String name){
        if(hero.getInventory().get(name) instanceof Weapon){
            Weapon weapon = (Weapon) hero.getInventory().get(name);
            weapon.setUsage(weapon.getUsage() - 1);
        }
        else if(hero.getInventory().get(name) instanceof Armor){
            Armor armor = (Armor) hero.getInventory().get(name);
            armor.setUsage(armor.getUsage() - 1);
        }
        else if(hero.getInventory().get(name) instanceof Potion){
            Potion potion = (Potion) hero.getInventory().get(name);
            potion.setUsage(potion.getUsage() - 1);
        }
        else if (hero.getInventory().get(name) instanceof Spell){
            Spell spell = (Spell) hero.getInventory().get(name);
            spell.setUsage(spell.getUsage() - 1);
        }
    }

    public void removeDeadMonsters(){
        MonsterRegistry monsterRegistry = MonsterRegistry.getInstance();
        List<String> deadMonsters = new ArrayList<>();
        for(String key : monsterRegistry.getMonsterMap().keySet()){
            if(monsterRegistry.getMonster(key).getHp() <= 0){
                deadMonsters.add(key);
            }
        }
        for(String key : deadMonsters){
            monsterRegistry.removeMonster(key);
        }
    }

    public int getLeftUsage(Hero hero, String name){
        if(hero.getInventory().get(name) instanceof Weapon){
            Weapon weapon = (Weapon) hero.getInventory().get(name);
            return weapon.getUsage();
        }
        else if(hero.getInventory().get(name) instanceof Armor){
            Armor armor = (Armor) hero.getInventory().get(name);
            return armor.getUsage();
        }
        else if(hero.getInventory().get(name) instanceof Potion){
            Potion potion = (Potion) hero.getInventory().get(name);
            return potion.getUsage();
        }
        else if (hero.getInventory().get(name) instanceof Spell){
            Spell spell = (Spell) hero.getInventory().get(name);
            return spell.getUsage();
        }
        return 0;
    }

    public void endBattle(){
        HeroRegistry heroRegistry = HeroRegistry.getInstance();
        MonsterRegistry monsterRegistry = MonsterRegistry.getInstance();
        int average_Monster_Level = 0;

        for(String key : monsterRegistry.getMonsterMap().keySet()){
            average_Monster_Level += monsterRegistry.getMonster(key).getLevel();
        }
        average_Monster_Level = average_Monster_Level / monsterRegistry.getMonsterMap().size();

        for(String key : heroRegistry.getHeroMap().keySet()){
            Hero hero = heroRegistry.getHero(key);
            if(hero.getHp() <= 0){
                hero.setHp(hero.getLevel() * 50);
                hero.setMana(hero.getLevel() * 50);
            }
            if(hero.getHp() > 0) {
                hero.setHp(hero.getHp() * 1.1);
                hero.setMana(hero.getMana() * 1.1);
                hero.setGold(hero.getGold() + average_Monster_Level * 100);
                hero.setXp(hero.getXp() + average_Monster_Level * monsterRegistry.getMonsterMap().size() * 2);
            }
            ifLevelUp(hero);
        };
    }

    public void ifLevelUp(Hero hero){
        if(hero.getXp() >= hero.getLevel() * 10){
            hero.levelUp();
            //hero.setXp(0);
        }
    }

    public boolean isHeroDoge(Hero hero){
        double dodgeChance = hero.getAgility() * 0.002;
        double random = Math.random();
        return random > dodgeChance;
    }

    public boolean isMonsterDoge(Monster monster){
        double dodgeChance = monster.getDodgeChance() * 0.01;
        double random = Math.random();
        return random > dodgeChance;
    }

    public double heroAttackDamage(Hero hero, Monster monster) {
        double damage = hero.getStrength() * 0.05;
        double defense = monster.getDefense() * 0.02;
        return damage - defense;
    }

    public double monsterAttackDamage(Monster monster, Hero hero) {
        double damage = monster.getDamage() * 0.05;
        double defense = hero.getAgility() * 0.02;
        return damage - defense;
    }

    public boolean heroAttack(Hero hero, Monster monster){
        boolean isMonsterDoge = isMonsterDoge(monster);
        if(isMonsterDoge){
            monster.setHp(monster.getHp() - heroAttackDamage(hero, monster));
            StringBuilder sb = new StringBuilder();
            sb.append("Hero: ").append(hero.getName()).append(" attacked monster: ").append(monster.getName());
            sb.append(" with damage: ").append(heroAttackDamage(hero, monster));
            System.out.println(sb);
        } else {
            System.out.println("Hero: " + hero.getName() + " missed");
        }
        return isMonsterDoge;
    }

    public boolean monsterAttack(Monster monster, Hero hero){
        boolean isHeroDoge = isHeroDoge(hero);
        if(isHeroDoge){
            hero.setHp(hero.getHp() - monsterAttackDamage(monster, hero));
            StringBuilder sb = new StringBuilder();
            sb.append("Monster: ").append(monster.getName()).append(" attacked hero: ").append(hero.getName());
            sb.append(" with damage: ").append(monsterAttackDamage(monster, hero));
            System.out.println(sb);
        } else {
            System.out.println("Monster: " + monster.getName() + " missed");
        }
        return isHeroDoge;
    }


}
