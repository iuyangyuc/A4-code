import java.util.HashMap;
import java.util.Map;

public class HeroRegistry {

    private static HeroRegistry instance;

    private Map<String, Hero> heroMap;

    private HeroRegistry() {
        heroMap = new HashMap<>();
    }

    public static HeroRegistry getInstance() {
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
}
