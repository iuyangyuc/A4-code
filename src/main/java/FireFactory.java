import java.util.ArrayList;

public class FireFactory implements SpellFactory {
    public Spell createSpell(ArrayList<Object> attributes) {
        return new Fire(attributes);
    }
}
