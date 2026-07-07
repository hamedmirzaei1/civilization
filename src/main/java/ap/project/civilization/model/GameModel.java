package ap.project.civilization.model;

import ap.project.civilization.model.hex.HexManager;
import ap.project.civilization.model.unit.UnitManager;

public class GameModel {
    private HexManager hexManager;
    private UnitManager unitManager;

    public GameModel() {
        hexManager = new HexManager();
        unitManager = new UnitManager(hexManager);
    }

    public void update() {
    }

    public HexManager getHexManager() {
        return hexManager;
    }

    public UnitManager getUnitManager() {
        return unitManager;
    }
}
