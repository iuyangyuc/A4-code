import java.util.ArrayList;

public class PaladinFactory implements HeroFactory {
    public Hero createHero(ArrayList<Object> attributes) {
        return new Paladin(attributes);
    }
}
