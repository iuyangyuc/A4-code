import java.util.ArrayList;

public class LightningFactory implements SpellFactory {
    public Spell createSpell(ArrayList<Object> attributes) {
        return new Lightning(attributes);
    }
}
