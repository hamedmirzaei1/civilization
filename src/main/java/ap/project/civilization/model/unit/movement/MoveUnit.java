package ap.project.civilization.model.unit.movement;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.hex.HexManager;
import ap.project.civilization.model.unit.base.Unit;

public class MoveUnit {
    private static int speed = 2;

    public static void moveToHex(Unit unit, Hex targetHex, HexManager hexManager) {
        if(!targetHex.isMovable()) return;
        unit.setTargetHex(
                targetHex,
                hexManager.getPixelCoords().get(targetHex).x,
                hexManager.getPixelCoords().get(targetHex).y);

        double targetX = hexManager.getPixelCoords().get(targetHex).x;
        double targetY = hexManager.getPixelCoords().get(targetHex).y;

        double baseX = hexManager.getPixelCoords().get(unit.getCurrentHex()).x;
        double baseY = hexManager.getPixelCoords().get(unit.getCurrentHex()).y;

        double distance = Math.hypot(targetX-baseX, targetY-baseY);
        if(distance == 0) return;
        unit.setDx((targetX-baseX) / distance * speed);
        unit.setDy((targetY-baseY) / distance * speed);

        unit.setMoving(true);
    }

    public static void setNeighborsMovable(Unit unit, boolean movable) {
        if(unit.getCurrentHex() == null) return;
        for(Hex h : FogOfWar.neigbors(unit.getCurrentHex(), HexManager.getInstance())) {
            h.setMovable(movable);
        }
    }

    public static int getSpeed() {
        return speed;
    }


}
