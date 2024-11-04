import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Market {

    private HashMap<String, Potion> potions = new HashMap<String, Potion>();
    private HashMap<String, Weapon> weapons = new HashMap<String, Weapon>();
    private HashMap<String, Spell> spells = new HashMap<String, Spell>();
    private HashMap<String, Object> market = new HashMap<String, Object>();
    JSONArray potionsArray = JsonArrayHolder.getInstance().getPotionJSONArray();
    JSONArray weaponsArray = JsonArrayHolder.getInstance().getWeaponJSONArray();
    JSONArray spellsArray = JsonArrayHolder.getInstance().getSpellJSONArray();
    HeroRegistry heroRegistry = HeroRegistry.getInstance();

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
            ArrayList<Object> attributes = new ArrayList<>();
            String name = weaponsArray.getJSONObject(i).getString("name");
            int cost = weaponsArray.getJSONObject(i).getInt("cost");
            int level = weaponsArray.getJSONObject(i).getInt("level");
            int damage = weaponsArray.getJSONObject(i).getInt("damage");
            int requiredHands = weaponsArray.getJSONObject(i).getInt("required_hands");
            Weapon weapon = new Weapon(name, cost, level, damage, requiredHands);
            weapons.put(name, weapon);
        }
    }

    private void createSpellList() {
        int l = spellsArray.length();
        for (int i = 0; i < l; i++) {
            ArrayList<Object> attributes = new ArrayList<>();
            String name = spellsArray.getJSONObject(i).getString("name");
            int cost = spellsArray.getJSONObject(i).getInt("cost");
            int level = spellsArray.getJSONObject(i).getInt("required_level");
            int damage = spellsArray.getJSONObject(i).getInt("damage");
            int manaCost = spellsArray.getJSONObject(i).getInt("mana_cost");
            String type = spellsArray.getJSONObject(i).getString("type");
            int usage = spellsArray.getJSONObject(i).getInt("Usage");
            if(type.equals("Ice")){
                Ice spell = new Ice(name, cost, level, damage, manaCost, usage);
                spells.put(name, spell);
            }
            else if(type.equals("Fire")){
                Fire spell = new Fire(name, cost, level, damage, manaCost, usage);
                spells.put(name, spell);
            }
            else if(type.equals("Lightning")){
                Lightning spell = new Lightning(name, cost, level, damage, manaCost, usage);
                spells.put(name, spell);
            }
        }
    }

    private void createRandomMarket() {
        createPotionList();
        createWeaponList();
        createSpellList();
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

        if (!spells.isEmpty()) {
            List<String> spellKeys = new ArrayList<>(spells.keySet());
            //String randomSpellKey = spellKeys.get(random.nextInt(spellKeys.size()));
            String randomSpellKey = spellKeys.get(0);
            market.put(randomSpellKey, spells.get(randomSpellKey));
        }
    }

     private void sellItem(String item_name, String hero_name) {
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

    private void buyItem(String item_name, String hero_name) {
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
