import java.util.HashMap;

public class MonsterRegistry {

    private static MonsterRegistry instance;

    private HashMap<String, Monster> monsterMap;

    private MonsterRegistry() {
        monsterMap = new HashMap<>();
    }

    public static MonsterRegistry getInstance() {
        if (instance == null) {
            synchronized (MonsterRegistry.class) {
                if (instance == null) {
                    instance = new MonsterRegistry();
                }
            }
        }
        return instance;
    }


    public void addMonster(String name, Monster monster) {
        monsterMap.put(name, monster);
    }

    public Monster getMonster(String name) {
        return monsterMap.get(name);
    }

    public void removeMonster(String name) {
        monsterMap.remove(name);
    }

    public HashMap<String, Monster> getMonsterMap() {
        return monsterMap;
    }
}
