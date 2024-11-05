import org.json.JSONArray;

public class JsonArrayHolder {
    private static JsonArrayHolder instance;

    private JSONArray warriorJSONArray;
    private JSONArray paladinJSONArray;
    private JSONArray sorcererJSONArray;
    private JSONArray potionJSONArray;
    private JSONArray weaponJSONArray;
    private JSONArray spellJSONArray;
    private JSONArray armorJSONArray;
    private JSONArray spiritJSONArray;
    private JSONArray dragonJSONArray;
    private JSONArray exoskeletonJSONArray;

    private JsonArrayHolder() {
    }

    public static JsonArrayHolder getInstance() {
        if (instance == null) {
            instance = new JsonArrayHolder();
        }
        return instance;
    }

    public JSONArray getWarriorJSONArray() {
        return warriorJSONArray;
    }

    public void setWarriorJSONArray(JSONArray warriorJSONArray) {
        this.warriorJSONArray = warriorJSONArray;
    }

    public JSONArray getPaladinJSONArray() {
        return paladinJSONArray;
    }

    public void setPaladinJSONArray(JSONArray paladinJSONArray) {
        this.paladinJSONArray = paladinJSONArray;
    }

    public JSONArray getSorcererJSONArray() {
        return sorcererJSONArray;
    }

    public void setSorcererJSONArray(JSONArray sorcererJSONArray) {
        this.sorcererJSONArray = sorcererJSONArray;
    }

    public JSONArray getPotionJSONArray() {
        return potionJSONArray;
    }

    public void setPotionJSONArray(JSONArray potionJSONArray) {
        this.potionJSONArray = potionJSONArray;
    }

    public JSONArray getWeaponJSONArray() {
        return weaponJSONArray;
    }

    public void setWeaponJSONArray(JSONArray weaponJSONArray) {
        this.weaponJSONArray = weaponJSONArray;
    }

    public JSONArray getSpellJSONArray() {
        return spellJSONArray;
    }

    public void setSpellJSONArray(JSONArray spellJSONArray) {
        this.spellJSONArray = spellJSONArray;
    }

    public JSONArray getArmorJSONArray() {
        return armorJSONArray;
    }

    public void setArmorJSONArray(JSONArray armorJSONArray) {
        this.armorJSONArray = armorJSONArray;
    }

    public JSONArray getSpiritJSONArray() {
        return spiritJSONArray;
    }

    public void setSpiritJSONArray(JSONArray spiritJSONArray) {
        this.spiritJSONArray = spiritJSONArray;
    }

    public JSONArray getDragonJSONArray() {
        return dragonJSONArray;
    }

    public void setDragonJSONArray(JSONArray dragonJSONArray) {
        this.dragonJSONArray = dragonJSONArray;
    }

    public JSONArray getExoskeletonJSONArray() {
        return exoskeletonJSONArray;
    }

    public void setExoskeletonJSONArray(JSONArray exoskeletonJSONArray) {
        this.exoskeletonJSONArray = exoskeletonJSONArray;
    }
}
