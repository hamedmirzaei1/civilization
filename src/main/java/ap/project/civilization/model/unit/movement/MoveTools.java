package ap.project.civilization.model.unit.movement;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.hex.HexManager;
import ap.project.civilization.model.unit.core.Unit;
import ap.project.civilization.model.unit.core.UnitManager;
import ap.project.civilization.view.util.ui.ViewConstants;

public class MoveTools {
    private static final int NORMAL_SPEED = 2;

    public static void moveToHex(Unit unit, Hex targetHex, HexManager hexManager, UnitManager unitManager) {
        if(!targetHex.isMovable()) return;

        int slot = Slot.findEmptySlot(targetHex, unitManager);
        if(slot == -1) return;
        Slot.releaseSlot(unit.getSlotNumber(), unit.getCurrentHex(), unitManager);
        unit.setSlotNumber(slot);

        double targetX = getTargetX(targetHex, slot, hexManager);
        double targetY = getTargetY(targetHex, slot, hexManager);

        unit.getMovement().setTarget(targetHex, targetX, targetY);
        applyVelocity(unit, targetX, targetY, NORMAL_SPEED);
    }

    private static void applyVelocity(Unit unit, double targetX, double targetY, double speed) {
        double unitX = unit.getMovement().getX();
        double unitY = unit.getMovement().getY();

        double distance = Math.hypot(targetX-unitX, targetY-unitY);
        if(distance == 0) return;
        unit.getMovement().setDx((targetX-unitX) / distance * speed);
        unit.getMovement().setDy((targetY-unitY) / distance * speed);

        unit.getMovement().setMoving(true);
    }

    private static double getTargetX(Hex targetHex, int slotNumber, HexManager hexManager) {
        double targetX = hexManager.getPixelCoords().get(targetHex).x;
        targetX += Slot.getSlots()[slotNumber].getOffsetX() * ViewConstants.HEX_BASE_SIZE;
        return targetX;
    }
    private static double getTargetY(Hex targetHex, int slotNumber, HexManager hexManager) {
        double targetY = hexManager.getPixelCoords().get(targetHex).y;
        targetY += Slot.getSlots()[slotNumber].getOffsetY() * ViewConstants.HEX_BASE_SIZE;
        return targetY;
    }


    public static void positionUnit(Unit unit, HexManager hexManager, double speed) {
        double targetX = getTargetX(unit.getCurrentHex(), unit.getSlotNumber(), hexManager);
        double targetY = getTargetY(unit.getCurrentHex(), unit.getSlotNumber(), hexManager);
        unit.getMovement().setTarget(null, targetX, targetY);
        applyVelocity(unit, targetX, targetY, speed);
    }

    public static void setNeighborsMovable(Unit unit, boolean movable) {
        if(unit.getCurrentHex() == null) return;
        for(Hex h : FogOfWar.neighbors(unit.getCurrentHex(), HexManager.getInstance())) {
            h.setMovable(movable);
        }
    }

    public static int getSpeed() {
        return NORMAL_SPEED;
    }

}
