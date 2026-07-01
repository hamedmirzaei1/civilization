package ap.project.civilization.model.terrain;

import ap.project.civilization.model.Clickable;

public class Hex implements Clickable {
    private int q;
    private int r;

    public Hex(int q, int r) {
        this.q = q;
        this.r = r;
    }

    @Override
    public boolean contains(int x, int y) {
        return false;
    }

    public int getQ() {
        return q;
    }

    public int getR() {
        return r;
    }
}