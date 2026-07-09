package ap.project.civilization.model.world.unit.movement;

import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.unit.UnitManager;
import ap.project.civilization.model.util.ModelConstants;

public class Slot {
    private final double offsetX;
    private final double offsetY;

    private static final double R = 0.42;

    private final static Slot[] SLOTS = {
//            new Slot(0.0, 0.0),
            new Slot(0.0, -R),
            new Slot(0.36, -R / 2),
            new Slot(0.36,  R / 2),
            new Slot(0.0,  R),
            new Slot(-0.36, R / 2),
            new Slot(-0.36,-R / 2)
    };

    public Slot(double offsetX, double offsetY) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public double getOffsetX() {
        return offsetX;
    }

    public double getOffsetY() {
        return offsetY;
    }

    public static Slot[] getSlots() {
        return SLOTS;
    }

    public static int findEmptySlot(Hex hex, UnitManager unitManager) {
        for(int i = 0; i< ModelConstants.HEX_SLOT_NUMBER; i++) {
            if(!unitManager.getHexSlots().get(hex)[i]) {
                acquireSlot(i, hex, unitManager);
                return i;
            }
        }
        return -1;
    }

    private static void acquireSlot(int i, Hex hex, UnitManager unitManager) {
        unitManager.getHexSlots().get(hex)[i] = true;
    }
    public static void releaseSlot(int i, Hex hex ,UnitManager unitManager) {
        unitManager.getHexSlots().get(hex)[i] = false;
    }
}
