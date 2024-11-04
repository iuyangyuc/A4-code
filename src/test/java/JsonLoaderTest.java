import org.json.JSONArray;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class JsonLoaderTest {

    @BeforeAll
    static void setUp() {
        JsonLoader.loadWarriorJSONArray();
        JsonLoader.loadSorcererJSONArray();
        JsonLoader.loadPaladinJSONArray();
        JsonLoader.loadPotionJSONArray();
        JsonLoader.loadWeaponJSONArray();
        JsonLoader.loadSpellJSONArray();
    }

    @Test
    void loadWarriorJSONArray() {
        JSONArray jsonArray = JsonArrayHolder.getInstance().getWarriorJSONArray();
        System.out.println(jsonArray);
    }

    @Test
    void loadSorcererJSONArray() {
        JSONArray jsonArray = JsonArrayHolder.getInstance().getSorcererJSONArray();
        System.out.println(jsonArray);
    }

    @Test
    void loadPaladinJSONArray() {
        JSONArray jsonArray = JsonArrayHolder.getInstance().getPaladinJSONArray();
        System.out.println(jsonArray);
    }

    @Test
    void loadPotionJSONArray() {
        JsonLoader.loadPotionJSONArray();
        JSONArray jsonArray = JsonArrayHolder.getInstance().getPotionJSONArray();
        System.out.println(jsonArray);
    }

    @Test
    void loadWeaponJSONArray() {
        JsonLoader.loadWeaponJSONArray();
        JSONArray jsonArray = JsonArrayHolder.getInstance().getWeaponJSONArray();
        System.out.println(jsonArray);
    }

    @Test
    void loadSpellJSONArray() {
        JsonLoader.loadSpellJSONArray();
        JSONArray jsonArray = JsonArrayHolder.getInstance().getSpellJSONArray();
        System.out.println(jsonArray);
    }

    @Test
    void isNameValid() {
        GameUtlity gameUtlity = new GameUtlity();
        assertNull(gameUtlity.isHeroNameValid("Paladin1"));
        System.out.println(gameUtlity.isHeroNameValid("Parzival"));
    }

    @Test
    void createHero() {
        GameUtlity gameUtlity = new GameUtlity();
        HeroFactory heroFactory = new WarriorFactory();
        HashMap<String, Hero> heroMap = new HashMap<>();
        ArrayList<Object> attributes = gameUtlity.getHeroInitialInfo("Eunoia_Cyn", gameUtlity.isHeroNameValid("Eunoia_Cyn"));
        ArrayList<Object> attributes2 = gameUtlity.getHeroInitialInfo("Undefeated_Yoj", gameUtlity.isHeroNameValid("Undefeated_Yoj"));
        Hero hero = heroFactory.createHero(attributes);
        Hero hero2 = heroFactory.createHero(attributes2);
        heroMap.put("Eunoia_Cyn", hero);
        heroMap.put("Undefeated_Yoj", hero2);
        hero.levelUp();
        hero2.levelUp();

        ArrayList<Object> a1 = new ArrayList<>();
        a1.add("Hp");
        Potion potion = new Potion("Potion of Healing", 10, 10, 10, a1, 2);
        hero.addInventory("Potion of Healing", potion);

        gameUtlity.heroToJSONFile(heroMap);
        JsonLoader.loadCurrentHeroJSONArray();

        ArrayList<Object> attributes3 = gameUtlity.getHeroCurrentInfo("Eunoia_Cyn", JsonArrayHolder.getInstance().getCurrentHeroJSONArray());
        ArrayList<Object> attributes4 = gameUtlity.getHeroCurrentInfo("Undefeated_Yoj", JsonArrayHolder.getInstance().getCurrentHeroJSONArray());
        Hero hero3 = heroFactory.createHero(attributes3);
        Hero hero4 = heroFactory.createHero(attributes4);
        System.out.println(hero3);
    }

}