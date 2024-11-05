public class BattleUtlity {

    public void equipWeapon(Hero hero, String weapon_name, int hand){
        //check if the weapon is in the inventory
        if(hero.getInventory().containsKey(weapon_name)){
            //check if the weapon is a weapon
            if(hero.getInventory().get(weapon_name) instanceof Weapon){
                Weapon weapon = (Weapon) hero.getInventory().get(weapon_name);
                //check if the hero has enough empty hands
                if(hero.getEmpty_hand() >= hand){
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
    }

    public void unEquipWeapon(Hero hero, String weapon_name, int hand){
        //check if the weapon is in the inventory
        if(hero.getEquipped().containsKey(weapon_name) || hero.getEmpty_hand() + hand > 2){
            //check if the weapon is a weapon
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
    }

    public void equipArmor(Hero hero, String armor_name){
        //check if the armor is in the inventory
        if(hero.getInventory().containsKey(armor_name)){
            //check if the armor is an armor
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
    }

    public void unEquipArmor(Hero hero, String armor_name){
        //check if the armor is in the inventory
        if(hero.getEquipped().containsKey(armor_name)){
            //check if the armor is an armor
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
    }

    public void useSpell(Hero hero, String spell_name){
    }
}
