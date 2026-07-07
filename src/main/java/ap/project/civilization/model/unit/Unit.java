package ap.project.civilization.model.unit;

import ap.project.civilization.model.hex.Hex;

public abstract class Unit {
    private Hex location;
    private UnitType unitType;

    private int maxAP;
    private int ap;

    public Unit(Hex location, UnitType unitType, int ap, int maxAP) {
        this.location = location;
        this.unitType = unitType;
        this.ap = ap;
        this.maxAP = maxAP;
    }
}
