package ap.project.civilization.model.unit.base;

import ap.project.civilization.model.hex.Hex;

public abstract class Unit {
    private Hex location;
    private UnitType unitType;

    private int maxAP;
    private int ap;

    private double x, y;
    double dx, dy;

    public Unit(Hex location, UnitType unitType, int ap, int maxAP, double x, double y) {
        this.location = location;
        this.unitType = unitType;
        this.ap = ap;
        this.maxAP = maxAP;

        this.x = x;
        this.y = y;
        dx =0;
        dy = 0;
    }

    public void move() {
        if(dx < 0.001 || dy < 0.001) return;
        x += dx;
        y += dy;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
