import java.util.ArrayList;

public class SorcererFactory implements HeroFactory {
    public Hero createHero(ArrayList<Object> attributes) {
        return new Sorcerer(attributes);
    }
}
