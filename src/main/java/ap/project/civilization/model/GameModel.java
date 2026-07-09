package ap.project.civilization.model;

import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.unit.UnitManager;

public class GameModel {
    private HexManager hexManager;
    private UnitManager unitManager;

    public GameModel() {
        hexManager = HexManager.getInstance();
        unitManager = UnitManager.getInstance();
        unitManager.spawnUnits(hexManager);
    }

    public void update() {
        unitManager.update();
    }

    public HexManager getHexManager() {
        return hexManager;
    }

    public UnitManager getUnitManager() {
        return unitManager;
    }
}
