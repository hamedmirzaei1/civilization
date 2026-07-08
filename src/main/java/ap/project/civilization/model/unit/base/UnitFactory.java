package ap.project.civilization.model.unit.base;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.hex.HexManager;
import ap.project.civilization.model.unit.movement.MoveTools;

public class UnitFactory {
    private final UnitManager unitManager;
    private final HexManager hexManager;

    public UnitFactory(UnitManager unitManager, HexManager hexManager) {
        this.unitManager = unitManager;
        this.hexManager = hexManager;
    }

    public void createUnit(UnitType unitType, Hex location) {
        Unit unit = unitType.create(location,
                hexManager.getPixelCoords().get(location).x,
                hexManager.getPixelCoords().get(location).y);

        unitManager.addUnit(unit, location);
        MoveTools.positionUnit(unit, hexManager, 1);
    }

}
