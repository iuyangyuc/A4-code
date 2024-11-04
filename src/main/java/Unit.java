public class Unit {

    private boolean accessible;
    private int type;
    private int x;
    private int y;

    public Unit() {
    }

    public Unit(UnitEvent event, int x, int y) {
        this.x = x;
        this.y = y;
        switch (event) {
            case EMPTY:
                accessible = true;
                type = 0;
                break;
            case ATTACK:
                accessible = true;
                type = 1;
                break;
            case MARKET:
                accessible = true;
                type = 2;
                break;
            case BLOCK:
                accessible = false;
                type = 3;
                break;
        }
    }

    public boolean isAccessible() {
        return accessible;
    }

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
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
}
