import java.util.ArrayList;

public class DragonFactory implements MonsterFactory {
    public Monster createMonster(ArrayList<Object> attributes) {
        return new Dragon(attributes);
    }
}
