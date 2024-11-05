public class Unit {

    private boolean accessible;
    private UnitEvent type;
    private int x;
    private int y;

    public Unit() {
    }

    public Unit(UnitEvent event, int x, int y) {
        this.x = x;
        this.y = y;
        this.type = event;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }

    public UnitEvent getType() {
        return type;
    }

    public void setType(UnitEvent type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getSymbol() {
        switch (type) {
            case EMPTY:
                return " ";
            case MARKET:
                return "M";
            case BLOCK:
                return "X";
            default:
                return " ";
        }
    }
}
