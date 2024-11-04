import java.util.Objects;

/*
UnitKey class to store and get the x and y coordinates of a unit.
 */

public class UnitKey {

    private final int x;
    private final int y;

    public UnitKey(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UnitKey unitKey = (UnitKey) obj;
        return x == unitKey.x && y == unitKey.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}