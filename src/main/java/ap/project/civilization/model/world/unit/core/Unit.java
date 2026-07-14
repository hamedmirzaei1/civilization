package ap.project.civilization.model.world.unit.core;

import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.unit.UnitManager;
import ap.project.civilization.model.world.unit.movement.Move;
import ap.project.civilization.model.world.unit.movement.MovementComponent;
import ap.project.civilization.model.world.unit.movement.Slot;
import ap.project.civilization.model.world.unit.movement.FogOfWar;

public abstract class Unit {
    private final UnitType type;

    private int ap;

    private final MovementComponent movement;
    private Hex currentHex;
    private boolean selected;

    int slotNumber;

    public void getFocus() {
        Move.setNeighborsMovable(this);
    }

    public void getApproach(Hex selectedHex) {
        Move.MoveToHex(this, selectedHex, HexManager.getInstance(), UnitManager.getInstance());
        Move.setNeighborsUnmovable(this);
    }

    public Unit(Hex currentHex, UnitType unitType, double x, double y) {
        this.currentHex = currentHex;
        this.type = unitType;
        this.ap = unitType.getMaxAP();

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
        if(slotNumber == -1) throw new IllegalStateException("there's no empty slot");
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

    public int getAp() {
        return ap;
    }

    public void reduceAP(int amount) {
        if(ap - amount < 0) throw new IllegalArgumentException("negative ap for unit");
        ap -= amount;
    }
    public void reviveAP() {
        ap = type.getMaxAP();
    }

    protected void setAP(int ap) {
        this.ap = ap;
    }
}
