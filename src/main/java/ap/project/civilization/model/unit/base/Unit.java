package ap.project.civilization.model.unit.base;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.unit.movement.MovementComponent;
import ap.project.civilization.model.unit.movement.Slot;
import ap.project.civilization.model.unit.movement.FogOfWar;
import ap.project.civilization.model.unit.movement.MoveTools;

public abstract class Unit {
    private final UnitType type;

    private final int maxAP;
    private int ap;

    private final MovementComponent movement;
    private Hex currentHex;
    private boolean selected;

    int slotNumber;

    public abstract void getFocus();
    public abstract void getApproach(Hex hex);

    public Unit(Hex currentHex, UnitType unitType, int ap, int maxAP, double x, double y) {
        this.currentHex = currentHex;
        this.type = unitType;
        this.ap = ap;
        this.maxAP = maxAP;

        selected = false;

        movement = new MovementComponent(x, y);

        findSlot();
        arrive();
    }

    public void arrive() {
        FogOfWar.makeUnitHexVisible(this);
    }

    private void findSlot() {
        slotNumber = Slot.findEmptySlot(currentHex, UnitManager.getInstance());
        if(slotNumber == -1) throw new IllegalStateException("there's no empty slot"); // todo : refactor architecture
    }

    public Hex getCurrentHex() {
        return currentHex;
    }
    public void setCurrentHex(Hex currentHex) {
        this.currentHex = currentHex;
    }

    public MovementComponent getMovement() {
        return movement;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public UnitType getType() {
        return type;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }
}
