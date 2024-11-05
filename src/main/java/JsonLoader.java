import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonLoader {

    private static final String pathPrefix = "src/main/java/";


    public static void loadWarriorJSONArray() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(pathPrefix + "warrior.json")));
            JSONArray jsonArray = new JSONArray(content);
            JsonArrayHolder.getInstance().setWarriorJSONArray(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadSorcererJSONArray() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(pathPrefix + "sorcerer.json")));
            JSONArray jsonArray = new JSONArray(content);
            JsonArrayHolder.getInstance().setSorcererJSONArray(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadPaladinJSONArray() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(pathPrefix + "paladins.json")));
            JSONArray jsonArray = new JSONArray(content);
            JsonArrayHolder.getInstance().setPaladinJSONArray(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void loadPotionJSONArray() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(pathPrefix + "potion.json")));
            JSONArray jsonArray = new JSONArray(content);
            JsonArrayHolder.getInstance().setPotionJSONArray(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadWeaponJSONArray() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(pathPrefix + "weapon.json")));
            JSONArray jsonArray = new JSONArray(content);
            JsonArrayHolder.getInstance().setWeaponJSONArray(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadSpellJSONArray() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(pathPrefix + "spell.json")));
            JSONArray jsonArray = new JSONArray(content);
            JsonArrayHolder.getInstance().setSpellJSONArray(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadCurrentHeroJSONArray() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(pathPrefix + "current.json")));
            JSONArray jsonArray = new JSONArray(content);
            JsonArrayHolder.getInstance().setCurrentHeroJSONArray(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
