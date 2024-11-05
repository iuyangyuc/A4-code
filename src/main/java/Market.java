import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Market {

    private HashMap<String, Potion> potions = new HashMap<String, Potion>();
    private HashMap<String, Weapon> weapons = new HashMap<String, Weapon>();
    private HashMap<String, Spell> spells = new HashMap<String, Spell>();
    private HashMap<String, Armor> armors = new HashMap<String, Armor>();
    private HashMap<String, Object> market = new HashMap<String, Object>();
    JSONArray potionsArray = JsonArrayHolder.getInstance().getPotionJSONArray();
    JSONArray weaponsArray = JsonArrayHolder.getInstance().getWeaponJSONArray();
    JSONArray spellsArray = JsonArrayHolder.getInstance().getSpellJSONArray();
    JSONArray armorsArray = JsonArrayHolder.getInstance().getArmorJSONArray();
    HeroRegistry heroRegistry = HeroRegistry.getInstance();
    GameUtlity gameUtility = new GameUtlity();

    private void createPotionList() {
        int l = potionsArray.length();
        for (int i = 0; i < l; i++) {
            ArrayList<Object> attributes = new ArrayList<>();
            String name = potionsArray.getJSONObject(i).getString("name");
            int cost = potionsArray.getJSONObject(i).getInt("cost");
            int level = potionsArray.getJSONObject(i).getInt("required_level");
            int usage = potionsArray.getJSONObject(i).getInt("Usage");
            int increaseValue = potionsArray.getJSONObject(i).getInt("attribute_increase");
            JSONArray attr = potionsArray.getJSONObject(i).getJSONArray("attribute_affected");
            for (int j = 0; j < attr.length(); j++) {
                attributes.add(attr.getString(j));
            }
            Potion potion = new Potion(name, cost, level, increaseValue, attributes, usage);
            potions.put(name, potion);
        }
    }

    private void createWeaponList() {
        int l = weaponsArray.length();
        for (int i = 0; i < l; i++) {
            ArrayList<Object> attributes = gameUtility.getWeaponInfo(weaponsArray.getJSONObject(i).getString("name"), weaponsArray);
            Weapon weapon = new Weapon(attributes);
            weapons.put(attributes.get(0).toString(), weapon);
        }
    }

    private void createSpellList() {
        int l = spellsArray.length();
        for (int i = 0; i < l; i++) {
            ArrayList<Object> attributes = gameUtility.getSpellInfo(spellsArray.getJSONObject(i).getString("name"), spellsArray);
            if(attributes.get(5).equals("Ice")){
                Ice spell = new Ice(attributes);
                spells.put(attributes.get(0).toString(), spell);
            }
            else if(attributes.get(5).equals("Fire")){
                Fire spell = new Fire(attributes);
                spells.put(attributes.get(0).toString(), spell);
            }
            else if(attributes.get(5).equals("Lightning")){
                Lightning spell = new Lightning(attributes);
                spells.put(attributes.get(0).toString(), spell);
            }
        }
    }

    private void createArmorList() {
        int l = armorsArray.length();
        for (int i = 0; i < l; i++) {
            ArrayList<Object> attributes = gameUtility.getArmorInfo(armorsArray.getJSONObject(i).getString("name"), armorsArray);
            Armor armor = new Armor(attributes);
            armors.put(attributes.get(0).toString(), armor);
        }
    }

    public void createRandomMarket() {
        createPotionList();
        createWeaponList();
        createSpellList();
        createArmorList();
        Random random = new Random();

        if (!potions.isEmpty()) {
            List<String> potionKeys = new ArrayList<>(potions.keySet());
            String randomPotionKey = potionKeys.get(random.nextInt(potionKeys.size()));
            market.put(randomPotionKey, potions.get(randomPotionKey));
        }

        if (!weapons.isEmpty()) {
            List<String> weaponKeys = new ArrayList<>(weapons.keySet());
            String randomWeaponKey = weaponKeys.get(random.nextInt(weaponKeys.size()));
            market.put(randomWeaponKey, weapons.get(randomWeaponKey));
        }

        if (!armors.isEmpty()) {
            List<String> armorKeys = new ArrayList<>(armors.keySet());
            String randomArmorKey = armorKeys.get(random.nextInt(armorKeys.size()));
            market.put(randomArmorKey, armors.get(randomArmorKey));
        }

        if (!spells.isEmpty()) {
            List<String> spellKeys = new ArrayList<>(spells.keySet());
            String randomSpellKey = spellKeys.get(random.nextInt(spellKeys.size()));
            //String randomSpellKey = spellKeys.get(0);
            market.put(randomSpellKey, spells.get(randomSpellKey));
        }
    }

     public void sellItem(String item_name, String hero_name) {
        Hero hero = heroRegistry.getHero(hero_name);
        hero.addInventory(item_name, market.get(item_name));
        double cost = 0;
        if(market.get(item_name) instanceof Potion){
            cost = ((Potion) market.get(item_name)).getCost();
        }
        else if(market.get(item_name) instanceof Weapon){
            cost = ((Weapon) market.get(item_name)).getCost();
        }
        else if(market.get(item_name) instanceof Spell){
            cost = ((Spell) market.get(item_name)).getCost();
        }
        hero.setGold(hero.getGold() - cost);
        market.remove(item_name);
    }

    public void buyItem(String item_name, String hero_name) {
        Hero hero = heroRegistry.getHero(hero_name);
        double cost = 0;
        String type = hero.getInventory().get(item_name).getClass().getTypeName();
        if(type.equals("Potion")){
            cost = ((Potion) hero.getInventory().get(item_name)).getCost();
        }
        else if(type.equals("Weapon")){
            cost = ((Weapon) hero.getInventory().get(item_name)).getCost();
        }
        else if(type.equals("Spell")){
            cost = ((Spell) hero.getInventory().get(item_name)).getCost();
        }
        market.put(item_name, hero.getInventory().get(item_name));
        hero.removeInventory(item_name);
        hero.setGold(hero.getGold() + cost/2);
    }

    public void repairItem(String name, String hero_name){
        Hero hero = heroRegistry.getHero(hero_name);
        double cost = 0;
        if(hero.getInventory().get(name) instanceof Spell){
            ((Spell) hero.getInventory().get(name)).setUsage(2);
        }
        if(hero.getInventory().get(name) instanceof Potion){
            ((Potion) hero.getInventory().get(name)).setUsage(2);
        }
        else if(hero.getInventory().get(name) instanceof Weapon){
            //((Weapon) hero.getInventory().get(name)).setUsage(2);
        }
        else if(hero.getInventory().get(name) instanceof Armor){
            //cost = ((Armor) hero.getInventory().get(name)).getCost();
        }
    }

    public void displayMarket(){
        for (String key : market.keySet()) {
            System.out.println(key + " : " + market.get(key));
        }
    }

    public int getItemCost(String item_name){
        if(market.get(item_name) instanceof Potion){
            return ((Potion) market.get(item_name)).getCost();
        }
        else if(market.get(item_name) instanceof Weapon){
            return ((Weapon) market.get(item_name)).getCost();
        }
        else if(market.get(item_name) instanceof Spell){
            return ((Spell) market.get(item_name)).getCost();
        }
        return 0;
    }

    public int getItemLevel(String item_name){
        if(market.get(item_name) instanceof Potion){
            return ((Potion) market.get(item_name)).getRequiredLevel();
        }
        else if(market.get(item_name) instanceof Weapon){
            return ((Weapon) market.get(item_name)).getRequiredLevel();
        }
        else if(market.get(item_name) instanceof Spell){
            return ((Spell) market.get(item_name)).getRequiredLevel();
        }
        return 0;
    }


    public HashMap<String, Potion> getPotions() {
        return potions;
    }

    public void setPotions(HashMap<String, Potion> potions) {
        this.potions = potions;
    }

    public HashMap<String, Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(HashMap<String, Weapon> weapons) {
        this.weapons = weapons;
    }

    public HashMap<String, Spell> getSpells() {
        return spells;
    }

    public void setSpells(HashMap<String, Spell> spells) {
        this.spells = spells;
    }

    public HashMap<String, Object> getMarket() {
        return market;
    }

    public void setMarket(HashMap<String, Object> market) {
        this.market = market;
    }
}
