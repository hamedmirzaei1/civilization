package ap.project.civilization.model.hex;

import ap.project.civilization.model.unit.base.UnitManager;
import ap.project.civilization.model.util.ModelConstants;

public class Slot {
    private final double offsetX;
    private final double offsetY;

    private static final double offsetCoef = 0.5;

    private final static Slot[] SLOTS = {
            new Slot(0, 0),
            new Slot(0, offsetCoef),
            new Slot(0, -offsetCoef),
            new Slot(offsetCoef, 0),
            new Slot(-offsetCoef, 0),
            new Slot(offsetCoef, offsetCoef),
            new Slot(-offsetCoef, -offsetCoef),
            new Slot(offsetCoef, -offsetCoef),
            new Slot(-offsetCoef, offsetCoef)
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
                return i;
            }
        }
        return -1;
    }
    public static void acquireSlot(int i, Hex hex, UnitManager unitManager) {
        unitManager.getHexSlots().get(hex)[i] = true;
    }
    public static void releaseSlot(int i, Hex hex ,UnitManager unitManager) {
        unitManager.getHexSlots().get(hex)[i] = false;
    }
}
