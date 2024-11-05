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
        HeroRegistry heroRegistry = HeroRegistry.getInstance();
        ArrayList<Object> a1 = new ArrayList<>();
        a1.add("Hp");

        ArrayList<Object> attributes = gameUtlity.getHeroInitialInfo("Eunoia_Cyn", gameUtlity.isHeroNameValid("Eunoia_Cyn"));
        ArrayList<Object> attributes2 = gameUtlity.getHeroInitialInfo("Undefeated_Yoj", gameUtlity.isHeroNameValid("Undefeated_Yoj"));
        Hero hero = heroFactory.createHero(attributes);
        Hero hero2 = heroFactory.createHero(attributes2);

        heroRegistry.addHero("Eunoia_Cyn", hero);
        heroRegistry.addHero("Undefeated_Yoj", hero2);

        hero.levelUp();
        hero2.levelUp();

        System.out.println(heroRegistry.getHero("Eunoia_Cyn"));

        //public Potion(String name, int cost, int requiredLevel, int increaseValue, ArrayList<Object> attribute, int usage)
        Potion p1 = new Potion("Health Potion", 10, 10, 10, a1, 10);
        hero.addInventory("Health Potion", p1);
        System.out.println(heroRegistry.getHero("Eunoia_Cyn"));
    }

    @Test
    void createHero2() {
        GameUtlity gameUtlity = new GameUtlity();
        HeroFactory heroFactory = new PaladinFactory();
        HeroFactory heroFactory1 = new SorcererFactory();
        HeroRegistry heroRegistry = HeroRegistry.getInstance();
        ArrayList<Object> a1 = new ArrayList<>();
        a1.add("Hp");

        ArrayList<Object> attributes = gameUtlity.getHeroInitialInfo("Caliber_Heist", gameUtlity.isHeroNameValid("Caliber_Heist"));
        ArrayList<Object> attributes2 = gameUtlity.getHeroInitialInfo("Kalabar", gameUtlity.isHeroNameValid("Kalabar"));
        Hero hero = heroFactory.createHero(attributes);
        Hero hero2 = heroFactory1.createHero(attributes2);

        heroRegistry.addHero("Caliber_Heist", hero);
        heroRegistry.addHero("Kalabar", hero2);

        System.out.println(heroRegistry.getHero("Caliber_Heist"));
        System.out.println();
        System.out.println(heroRegistry.getHero("Kalabar"));
        System.out.println();

        hero.levelUp();
        hero2.levelUp();

        System.out.println(heroRegistry.getHero("Caliber_Heist"));
        System.out.println(hero.getType());
        System.out.println(heroRegistry.getHero("Kalabar"));
        System.out.println(hero2.getType());
    }

    @Test
    void potionTest() {
        GameUtlity gameUtlity = new GameUtlity();
        ArrayList<Object> a1 = gameUtlity.getPotionInfo("Ambrosia", JsonArrayHolder.getInstance().getPotionJSONArray());
        Potion p1 = new Potion(a1);
        System.out.println(p1);
    }

    @Test
    void removeUsedItem(){
        GameUtlity gameUtlity = new GameUtlity();
        HeroFactory heroFactory = new PaladinFactory();
        HeroFactory heroFactory1 = new SorcererFactory();
        HeroRegistry heroRegistry = HeroRegistry.getInstance();
        ArrayList<Object> a1 = new ArrayList<>();
        a1.add("Hp");

        ArrayList<Object> attributes = gameUtlity.getHeroInitialInfo("Caliber_Heist", gameUtlity.isHeroNameValid("Caliber_Heist"));
        ArrayList<Object> attributes2 = gameUtlity.getHeroInitialInfo("Kalabar", gameUtlity.isHeroNameValid("Kalabar"));
        Hero hero = heroFactory.createHero(attributes);
        Hero hero2 = heroFactory1.createHero(attributes2);

        heroRegistry.addHero("Caliber_Heist", hero);
        heroRegistry.addHero("Kalabar", hero2);

        hero.levelUp();
        hero2.levelUp();

        System.out.println(heroRegistry.getHero("Caliber_Heist"));

        //public Potion(String name, int cost, int requiredLevel, int increaseValue, ArrayList<Object> attribute, int usage)
        Potion p1 = new Potion("Health Potion", 10, 10, 10, a1, 0);
        hero.addInventory("Health Potion", p1);
        System.out.println(heroRegistry.getHero("Caliber_Heist"));

        gameUtlity.removeUsedItem();
        System.out.println(heroRegistry.getHero("Caliber_Heist"));

    }

//    @Test
//    void potionListTest() {
//        Market market = new Market();
//        market.createPotionList();
//        System.out.println(market.getPotions());
//    }

//    @Test
//    void spellListTest() {
//        Market market = new Market();
//        market.createSpellList();
//        System.out.println(market.getSpells());
//    }

//    @Test
//    void weaponListTest() {
//        Market market = new Market();
//        market.createWeaponList();
//        System.out.println(market.getWeapons());
//    }

//    @Test
//    void marketTest() {
//        Market market = new Market();
//        market.createRandomMarket();
//        System.out.println(market.getMarket());
//    }

    @Test
    void sellItemTest() {
        GameUtlity gameUtlity = new GameUtlity();
        HeroFactory heroFactory = new WarriorFactory();
        HeroRegistry heroRegistry = HeroRegistry.getInstance();

        ArrayList<Object> attributes = gameUtlity.getHeroInitialInfo("Eunoia_Cyn", gameUtlity.isHeroNameValid("Eunoia_Cyn"));
        ArrayList<Object> attributes2 = gameUtlity.getHeroInitialInfo("Undefeated_Yoj", gameUtlity.isHeroNameValid("Undefeated_Yoj"));
        Hero hero = heroFactory.createHero(attributes);
        Hero hero2 = heroFactory.createHero(attributes2);

        heroRegistry.addHero("Eunoia_Cyn", hero);
        heroRegistry.addHero("Undefeated_Yoj", hero2);

        Market market = new Market();
        market.createRandomMarket();
        System.out.println(market.getMarket());
        System.out.println();

        market.sellItem("Heat_Wave", "Eunoia_Cyn");

        System.out.println(market.getMarket());
        System.out.println();
        System.out.println(heroRegistry.getHero("Eunoia_Cyn"));
    }

    @Test
    void buyItemTest(){
        GameUtlity gameUtlity = new GameUtlity();
        HeroFactory heroFactory = new WarriorFactory();
        HeroRegistry heroRegistry = HeroRegistry.getInstance();

        ArrayList<Object> attributes = gameUtlity.getHeroInitialInfo("Eunoia_Cyn", gameUtlity.isHeroNameValid("Eunoia_Cyn"));
        ArrayList<Object> attributes2 = gameUtlity.getHeroInitialInfo("Undefeated_Yoj", gameUtlity.isHeroNameValid("Undefeated_Yoj"));
        Hero hero = heroFactory.createHero(attributes);
        Hero hero2 = heroFactory.createHero(attributes2);

        heroRegistry.addHero("Eunoia_Cyn", hero);
        heroRegistry.addHero("Undefeated_Yoj", hero2);

        ArrayList<Object> a1 = gameUtlity.getPotionInfo("Ambrosia", JsonArrayHolder.getInstance().getPotionJSONArray());
        Potion p1 = new Potion(a1);

        heroRegistry.getHero("Eunoia_Cyn").addInventory("Ambrosia", p1);

        Market market = new Market();
        market.createRandomMarket();
        System.out.println(market.getMarket());
        System.out.println();
        System.out.println(heroRegistry.getHero("Eunoia_Cyn"));
        System.out.println();

        market.buyItem("Ambrosia", "Eunoia_Cyn");

        System.out.println(market.getMarket());
        System.out.println();
        System.out.println(heroRegistry.getHero("Eunoia_Cyn"));
    }

}