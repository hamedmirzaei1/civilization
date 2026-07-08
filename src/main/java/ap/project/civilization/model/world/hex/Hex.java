package ap.project.civilization.model.world.hex;

public abstract class Hex {
    private final HexCoord coordinate;
    private boolean visible;
    private boolean unlock;
    private boolean selected;
    private boolean movable;

    public Hex(HexCoord coordinate) {
        this.coordinate = coordinate;
        visible = false;
        unlock = false;
        selected = false;
        movable = false;
    }

    public HexCoord getCoordinate() {
        return coordinate;
    }
    public int getQ() {
        return coordinate.getQ();
    }
    public int getR() {
        return coordinate.getR();
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean isUnlock() {
        return unlock;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setUnlock(boolean unlock) {
        this.unlock = unlock;
    }

    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isMovable() {
        return movable;
    }
    public void setMovable(boolean movable) {
        this.movable = movable;
    }
}