package ap.project.civilization.model.hex;

import ap.project.civilization.model.Clickable;

public abstract class Hex implements Clickable {
    private final HexCoord coordinate;
    private boolean visible;

    public Hex(HexCoord coordinate) {
        this.coordinate = coordinate;
        visible = true;
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
}