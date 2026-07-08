package ap.project.civilization.model.unit.movement;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.hex.HexManager;
import ap.project.civilization.model.hex.Slot;
import ap.project.civilization.model.unit.base.Unit;
import ap.project.civilization.model.unit.base.UnitManager;
import ap.project.civilization.view.util.ui.ViewConstants;

public class MoveUnit {
    private static int speed = 2;

    public static void moveToHex(Unit unit, Hex targetHex, HexManager hexManager, UnitManager unitManager) {
        if(!targetHex.isMovable()) return;
        double targetX = hexManager.getPixelCoords().get(targetHex).x;
        double targetY = hexManager.getPixelCoords().get(targetHex).y;

        int slot = Slot.findEmptySlot(targetHex, unitManager);
        if(slot == -1) return;

        targetX += Slot.getSlots()[slot].getOffsetX() * ViewConstants.HEX_BASE_SIZE;
        targetY += Slot.getSlots()[slot].getOffsetY() * ViewConstants.HEX_BASE_SIZE;

        unit.setTargetHex(targetHex, targetX, targetY);

        applyVelocity(unit, hexManager, targetX, targetY);
        Slot.releaseSlot(unit.getSlot(), unit.getCurrentHex(), unitManager);
        unit.setSlot(slot);
        unit.setMoving(true);
    }

    private static void applyVelocity(Unit unit, HexManager hexManager, double targetX, double targetY) {

        double distance = Math.hypot(targetX-unit.getX(), targetY-unit.getY());
        if(distance == 0) return;
        unit.setDx((targetX-unit.getX()) / distance * speed);
        unit.setDy((targetY-unit.getY()) / distance * speed);
    }

    public static void setNeighborsMovable(Unit unit, boolean movable) {
        if(unit.getCurrentHex() == null) return;
        for(Hex h : FogOfWar.neighbors(unit.getCurrentHex(), HexManager.getInstance())) {
            h.setMovable(movable);
        }
    }

    public static int getSpeed() {
        return speed;
    }

}
