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
                spellInfo.add(jsonArray.getJSONObject(i).get("usage"));
            }
        }
        return spellInfo;
    }
}
