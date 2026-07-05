package ap.project.civilization.model.hex;

import ap.project.civilization.model.Clickable;

public abstract class Hex implements Clickable {
    private final HexCoord coordinate;
    private boolean visible;
    private boolean unlock;

    public Hex(HexCoord coordinate) {
        this.coordinate = coordinate;
        visible = false;
        unlock = false;
    }

    @Override
    public boolean contains(int x, int y) {
        return false;
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
}