import org.json.JSONArray;

public class JsonArrayHolder {
    private static JsonArrayHolder instance;
    private JSONArray jsonArray;

    private JsonArrayHolder() {
        // Private constructor to prevent instantiation
    }

    public static JsonArrayHolder getInstance() {
        if (instance == null) {
            instance = new JsonArrayHolder();
        }
        return instance;
    }

    public JSONArray getJsonArray() {
        return jsonArray;
    }

    public void setJsonArray(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }
}
