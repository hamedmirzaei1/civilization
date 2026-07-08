package ap.project.civilization.model.unit.movement;

public enum Direction {
    UP_LEFT(0, -1),
    UP_RIGHT(1, -1),
    LEFT(-1, 0),
    RIGHT(1,0 ),
    DOWN_LEFT(-1,1 ),
    DOWN_RIGHT(0,1);

    private final int dq;
    private final int dr;

    Direction(int dq, int dr) {
        this.dq = dq;
        this.dr = dr;
    }

    public int getDq() {
        return dq;
    }

    public int getDr() {
        return dr;
    }
}
