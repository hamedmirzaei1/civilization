package ap.project.civilization.model.hex;

import ap.project.civilization.model.Clickable;

public abstract class Hex implements Clickable {
    private final HexCoord coordinate;

    public Hex(HexCoord coordinate) {
        this.coordinate = coordinate;
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
}