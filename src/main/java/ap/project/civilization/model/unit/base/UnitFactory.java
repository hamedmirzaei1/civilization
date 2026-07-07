package ap.project.civilization.model.unit.base;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.hex.HexManager;
import ap.project.civilization.model.unit.units.Explorer;

public class UnitFactory {
    private final UnitManager unitManager;
    private final HexManager hexManager;

    public UnitFactory(UnitManager unitManager, HexManager hexManager) {
        this.unitManager = unitManager;
        this.hexManager = hexManager;
    }

    public Unit createUnit(UnitType unitType, Hex location) {
        Unit unit;
        if(unitType == UnitType.EXPLORER) {
            unit = new Explorer(location,
                    hexManager.getPixelCoords().get(location).x,
                    hexManager.getPixelCoords().get(location).y);

            unitManager.addUnit(unit, location);
            return unit;
        }
        //todo
        return null;
    }
}
