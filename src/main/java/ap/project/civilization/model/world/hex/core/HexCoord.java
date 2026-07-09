package ap.project.civilization.model.world.hex.core;

public class HexCoord {
    private final int q;
    private final int r;


    public HexCoord(int q, int r) {
        this.q = q;
        this.r = r;
    }


    public int getQ() {
        return q;
    }

    public int getR() {
        return r;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof HexCoord)) return false;

        HexCoord other = (HexCoord) obj;
        return q == other.q && r == other.r;
    }

    @Override
    public int hashCode() {
        return 31 * q + r;
    }
}
