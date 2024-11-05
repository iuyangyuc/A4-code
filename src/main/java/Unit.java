public class Unit {

    private boolean current;
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

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
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
                if(current) {
                    return "P";
                } else {
                    return " ";
                }
            case MARKET:
                if (current) {
                    return "P";
                } else {
                    return "M";
                }
            case BLOCK:
                if(current) {
                    return "P";
                } else {
                    return "X";
                }
            default:
                return " ";
        }
    }
}
