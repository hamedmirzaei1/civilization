package ap.project.civilization.model.unit.base;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.unit.movement.FogOfWar;
import ap.project.civilization.model.unit.movement.MoveUnit;

public abstract class Unit {
    private UnitType unitType;

    private int maxAP;
    private int ap;

    private Hex currentHex;
    private Hex targetHex;
    private double targetX, targetY;

    private double x, y;
    double dx, dy;
    private boolean moving;

    public void arrive() {
        FogOfWar.makeUnitHexVisible(this);
    }
    public abstract void getFocus();
    public abstract void getApproach(Hex hex);

    private boolean selected;
    public Unit(Hex currentHex, UnitType unitType, int ap, int maxAP, double x, double y) {
        this.currentHex = currentHex;
        this.unitType = unitType;
        this.ap = ap;
        this.maxAP = maxAP;

        this.x = x;
        this.y = y;
        dx = 0;
        dy = 0;
        moving = false;

        selected = false;
    }

    public void update(UnitManager unitManager) {
        if(!moving) return;
        if(arrived()) {
            x = targetX;
            y = targetY;

            unitManager.changeHexLocation(this, currentHex, targetHex);
            currentHex = targetHex;
            targetHex = null;

            dx = 0;
            dy = 0;
            moving = false;

            arrive();
            return;
        }

        x += dx;
        y += dy;
    }

    public boolean arrived() {
        return Math.hypot(targetX - x, targetY - y) <= MoveUnit.getSpeed();
    }

    public Hex getCurrentHex() {
        return currentHex;
    }

    public void setTargetHex(Hex targetHex, double targetX, double targetY) {
        this.targetHex = targetHex;
        this.targetX = targetX;
        this.targetY = targetY;
    }

    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }
    public void setDy(double dy) {
        this.dy = dy;
    }

    public boolean isMoving() {
        return moving;
    }
    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}
