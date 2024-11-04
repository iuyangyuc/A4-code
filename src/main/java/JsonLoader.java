import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonLoader {


    public static void loadWarriorJSONArray() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("src/main/java/warrior.json")));
            JSONArray jsonArray = new JSONArray(content);
            JsonArrayHolder.getInstance().setWarriorJSONArray(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadSorcererJSONArray() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("src/main/java/sorcerer.json")));
            JSONArray jsonArray = new JSONArray(content);
            JsonArrayHolder.getInstance().setSorcererJSONArray(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadPaladinJSONArray() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("src/main/java/paladins.json")));
            JSONArray jsonArray = new JSONArray(content);
            JsonArrayHolder.getInstance().setPaladinJSONArray(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void loadPotionJSONArray() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("src/main/java/potion.json")));
            JSONArray jsonArray = new JSONArray(content);
            JsonArrayHolder.getInstance().setPotionJSONArray(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadWeaponJSONArray() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("src/main/java/weapon.json")));
            JSONArray jsonArray = new JSONArray(content);
            JsonArrayHolder.getInstance().setWeaponJSONArray(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadSpellJSONArray() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("src/main/java/spell.json")));
            JSONArray jsonArray = new JSONArray(content);
            JsonArrayHolder.getInstance().setSpellJSONArray(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadCurrentHeroJSONArray() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("src/main/java/current.json")));
            JSONArray jsonArray = new JSONArray(content);
            JsonArrayHolder.getInstance().setCurrentHeroJSONArray(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
