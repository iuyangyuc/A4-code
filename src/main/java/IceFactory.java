import java.util.ArrayList;

public class IceFactory implements SpellFactory {
    public Spell createSpell(ArrayList<Object> attributes) {
        return new Ice(attributes);
    }
}
