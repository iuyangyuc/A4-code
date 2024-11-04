import java.util.ArrayList;

public class WarriorFactory implements HeroFactory {
    public Hero createHero(ArrayList<Object> attributes) {
        return new Warrior(attributes);
    }
}
