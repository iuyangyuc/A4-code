import java.util.ArrayList;

public class SpiritFactory implements MonsterFactory {
    public Monster createMonster(ArrayList<Object> attributes) {
        return new Spirit(attributes);
    }
}
