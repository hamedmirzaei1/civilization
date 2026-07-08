package ap.project.civilization.model.world.unit.movement;

import ap.project.civilization.model.world.hex.Hex;

public class MovementComponent {
    private double x, y;
    private double dx, dy;
    private boolean moving;

    private Hex targetHex;
    private double targetX, targetY;

    public MovementComponent(double x, double y) {
        this.x = x;
        this.y = y;
        dx = 0;
        dy = 0;
        moving = false;
    }

    public boolean arrived() {
        return Math.hypot(targetX - x, targetY - y) <= MoveTools.getSpeed();
    }

    public void setTarget(Hex targetHex, double targetX, double targetY) {
        this.targetHex = targetHex;
        this.targetX = targetX;
        this.targetY = targetY;
    }
    public void setTargetHex(Hex targetHex) {
        this.targetHex = targetHex;
    }

    public Hex getTargetHex() {
        return targetHex;
    }

    public boolean isMoving() {
        return moving;
    }
    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }
    public void setDy(double dy) {
        this.dy = dy;
    }

    public double getDx() {
        return dx;
    }
    public double getDy() {
        return dy;
    }

    public double getTargetX() {
        return targetX;
    }
    public double getTargetY() {
        return targetY;
    }
}
