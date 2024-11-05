import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;

public class GameUtlity {

    public JSONArray isHeroNameValid(String name) {
        JSONArray pjsonArray = JsonArrayHolder.getInstance().getPaladinJSONArray();
        JSONArray wjsonArray = JsonArrayHolder.getInstance().getWarriorJSONArray();
        JSONArray sjsonArray = JsonArrayHolder.getInstance().getSorcererJSONArray();

        if (pjsonArray != null) {
            for (int i = 0; i < pjsonArray.length(); i++) {
                if (pjsonArray.getJSONObject(i).getString("name").equals(name)) {
                    return pjsonArray;
                }
            }
        }

        if (wjsonArray != null) {
            for (int i = 0; i < wjsonArray.length(); i++) {
                if (wjsonArray.getJSONObject(i).getString("name").equals(name)) {
                    return wjsonArray;
                }
            }
        }

        if (sjsonArray != null) {
            for (int i = 0; i < sjsonArray.length(); i++) {
                if (sjsonArray.getJSONObject(i).getString("name").equals(name)) {
                    return sjsonArray;
                }
            }
        }
        return null;
    }

    public ArrayList<Object> getHeroInitialInfo(String name, JSONArray jsonArray){
        ArrayList<Object> heroInfo = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            if (jsonArray.getJSONObject(i).getString("name").equals(name)) {
                heroInfo.add(jsonArray.getJSONObject(i).get("name"));
                heroInfo.add(jsonArray.getJSONObject(i).get("mana"));
                heroInfo.add(jsonArray.getJSONObject(i).get("strength"));
                heroInfo.add(jsonArray.getJSONObject(i).get("agility"));
                heroInfo.add(jsonArray.getJSONObject(i).get("dexterity"));
                heroInfo.add(jsonArray.getJSONObject(i).get("starting_money"));
                heroInfo.add(jsonArray.getJSONObject(i).get("starting_level"));
                heroInfo.add(jsonArray.getJSONObject(i).get("type"));
            }
        }
        return heroInfo;
    }

    public ArrayList<Object> getPotionInfo(String name, JSONArray jsonArray){
        ArrayList<Object> potionInfo = new ArrayList<>();
        ArrayList<String> attributes = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            if (jsonArray.getJSONObject(i).getString("name").equals(name)) {
                potionInfo.add(jsonArray.getJSONObject(i).get("name"));
                potionInfo.add(jsonArray.getJSONObject(i).get("cost"));
                potionInfo.add(jsonArray.getJSONObject(i).get("required_level"));
                potionInfo.add(jsonArray.getJSONObject(i).get("attribute_increase"));
                JSONArray jsonArray1 = jsonArray.getJSONObject(i).getJSONArray("attribute_affected");
                for (int j = 0; j < jsonArray1.length(); j++) {
                    attributes.add(jsonArray1.getString(j));
                }
                potionInfo.add(attributes);
                potionInfo.add(jsonArray.getJSONObject(i).get("Usage"));
            }
        }
        return potionInfo;
    }

    public ArrayList<Object> getWeaponInfo(String name, JSONArray jsonArray){
        ArrayList<Object> weaponInfo = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            if (jsonArray.getJSONObject(i).getString("name").equals(name)) {
                weaponInfo.add(jsonArray.getJSONObject(i).get("name"));
                weaponInfo.add(jsonArray.getJSONObject(i).get("cost"));
                weaponInfo.add(jsonArray.getJSONObject(i).get("level"));
                weaponInfo.add(jsonArray.getJSONObject(i).get("damage"));
                weaponInfo.add(jsonArray.getJSONObject(i).get("required_hands"));
            }
        }
        return weaponInfo;
    }

    public ArrayList<Object> getSpellInfo(String name, JSONArray jsonArray){
        ArrayList<Object> spellInfo = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            if (jsonArray.getJSONObject(i).getString("name").equals(name)) {
                spellInfo.add(jsonArray.getJSONObject(i).get("name"));
                spellInfo.add(jsonArray.getJSONObject(i).get("cost"));
                spellInfo.add(jsonArray.getJSONObject(i).get("required_level"));
                spellInfo.add(jsonArray.getJSONObject(i).get("damage"));
                spellInfo.add(jsonArray.getJSONObject(i).get("mana_cost"));
                spellInfo.add(jsonArray.getJSONObject(i).get("type"));
                spellInfo.add(jsonArray.getJSONObject(i).get("Usage"));
            }
        }
        return spellInfo;
    }

    public ArrayList<Object> getArmorInfo(String name, JSONArray jsonArray){
        ArrayList<Object> armorInfo = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            if (jsonArray.getJSONObject(i).getString("name").equals(name)) {
                armorInfo.add(jsonArray.getJSONObject(i).get("name"));
                armorInfo.add(jsonArray.getJSONObject(i).get("cost"));
                armorInfo.add(jsonArray.getJSONObject(i).get("required_level"));
                armorInfo.add(jsonArray.getJSONObject(i).get("damage_reduction"));
            }
        }
        return armorInfo;
    }

    public void removeUsedItem(){
        HeroRegistry heroRegistry = HeroRegistry.getInstance();
        for(HashMap.Entry<String, Hero> entry : heroRegistry.getHeroMap().entrySet()){
            Hero hero = entry.getValue();
            HashMap<String, Object> items = hero.getInventory();
            for(HashMap.Entry<String, Object> item : items.entrySet()){
                if(item.getValue() instanceof Potion){
                    Potion potion = (Potion) item.getValue();
                    if(potion.getUsage() == 0){
                        items.remove(item.getKey());
                    }
                }
                if(item.getValue() instanceof Spell){
                    Spell spell = (Spell) item.getValue();
                    if(spell.getUsage() == 0){
                        items.remove(item.getKey());
                    }
                }
            }
        }
    }

    public int takeValidInput(int lowerLimit, int upperLimit) {
        int gameChoice = 0;
        while (true) {
            String input = Main.SCANNER.next();
            try {
                gameChoice = Integer.parseInt(input);
                if (gameChoice >= lowerLimit && gameChoice <= upperLimit) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between "+ lowerLimit +" and "+ upperLimit +".");
            }
        }
        return gameChoice;
    }

    public String selectHero(){
        int heroChoice = 0;
        System.out.println("Select a hero:");
        HeroRegistry heroRegistry = HeroRegistry.getInstance();
        int i = 1;
        for(HashMap.Entry<String, Hero> entry : heroRegistry.getHeroMap().entrySet()){
            System.out.println(i + ". " + entry.getValue());
            i++;
        }
        heroChoice = takeValidInput(1, i-1);
        return heroRegistry.getHeroMap().keySet().toArray()[heroChoice-1].toString();
    }

    public void createHeroParty(int heroNumber) {
        HeroFactory heroFactory = new PaladinFactory();
        HeroFactory heroFactory1 = new SorcererFactory();
        HeroFactory heroFactory2 = new WarriorFactory();
        HeroRegistry heroRegistry = HeroRegistry.getInstance();
        for (int i = 0; i < heroNumber; i++) {
            System.out.println("Enter the name of the hero:");
            String name = Main.SCANNER.next();
            while (isHeroNameValid(name) == null) {
                System.out.println("Invalid hero name. Please enter a valid hero name:");
                name = Main.SCANNER.next();
            }
            ArrayList<Object> attributes = getHeroInitialInfo(name, isHeroNameValid(name));
            if(attributes.get(7).equals("paladins")){
                Hero hero = heroFactory.createHero(attributes);
                System.out.println(hero);
                heroRegistry.addHero(name, hero);
            }
            else if(attributes.get(7).equals("sorcerer")){
                Hero hero = heroFactory1.createHero(attributes);
                System.out.println(hero);
                heroRegistry.addHero(name, hero);
            }
            else if(attributes.get(7).equals("warrior")){
                Hero hero = heroFactory2.createHero(attributes);
                System.out.println(hero);
            heroRegistry.addHero(name, hero);
            }
        }
    }

    public double keep2(double value) {
        String valueString = String.format("%.2f", value);
        return Double.parseDouble(valueString);
    }



    public void InitializeGame() {
        JsonLoader.loadWarriorJSONArray();
        JsonLoader.loadSorcererJSONArray();
        JsonLoader.loadPaladinJSONArray();
        JsonLoader.loadPotionJSONArray();
        JsonLoader.loadWeaponJSONArray();
        JsonLoader.loadSpellJSONArray();
        JsonLoader.loadArmorJSONArray();
        Board board = Board.getInstance();
        board.improvedSetBoard(8);
    }


}
