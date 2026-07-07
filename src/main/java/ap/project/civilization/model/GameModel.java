package ap.project.civilization.model;

import ap.project.civilization.model.hex.HexManager;
import ap.project.civilization.model.unit.base.UnitManager;

public class GameModel {
    private HexManager hexManager;
    private UnitManager unitManager;

    public GameModel() {
        hexManager = HexManager.getInstance();
        unitManager = new UnitManager(hexManager);
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
