import java.util.HashMap;
import java.util.Map;

public class HeroRegistry {

    private static HeroRegistry instance;

    private HashMap<String, Hero> heroMap;

    private HeroRegistry() {
        heroMap = new HashMap<>();
    }

    public static HeroRegistry getInstance() {
        if (instance == null) {
            synchronized (HeroRegistry.class) {
                if (instance == null) {
                    instance = new HeroRegistry();
                }
            }
        }
        return instance;
    }


    public void addHero(String name, Hero hero) {
        heroMap.put(name, hero);
    }

    public Hero getHero(String name) {
        return heroMap.get(name);
    }

    public void removeHero(String name) {
        heroMap.remove(name);
    }

    public HashMap<String, Hero> getHeroMap() {
        return heroMap;
    }
}
