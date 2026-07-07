package ap.project.civilization.model.unit;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.unit.units.Explorer;

public class UnitFactory {
    private UnitManager unitManager;

    public UnitFactory(UnitManager unitManager) {
        this.unitManager = unitManager;
    }

    public Unit createUnit(UnitType unitType, Hex location) {
        if(unitType == UnitType.EXPLORER) {
            unitManager.addUnit(new Explorer(location));
        }
        //todo
        return new Explorer(location);
    }
}
