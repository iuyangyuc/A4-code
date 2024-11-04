import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonLoader {
    public static void loadJsonArray() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("/Users/yyc/Desktop/CS611-OOP/untitled/src/main/java/hero.json")));
            JSONArray jsonArray = new JSONArray(content);
            JsonArrayHolder.getInstance().setJsonArray(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
