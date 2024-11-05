import java.util.ArrayList;

public class ExoskeletonFactory implements MonsterFactory {
    public Monster createMonster(ArrayList<Object> attributes) {
        return new Exoskeleton(attributes);
    }
}
