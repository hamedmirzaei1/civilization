package ap.project.civilization.model.world.unit.core;

import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.unit.UnitManager;
import ap.project.civilization.model.world.unit.movement.MoveTools;

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
