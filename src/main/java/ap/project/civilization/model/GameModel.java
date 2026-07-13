package ap.project.civilization.model;

import ap.project.civilization.model.gamestate.TurnState;
import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.unit.UnitManager;

public class GameModel {
    private final HexManager hexManager;
    private final UnitManager unitManager;
    private TurnState turnState;

    public GameModel() {
        hexManager = HexManager.getInstance();
        unitManager = UnitManager.getInstance();
        unitManager.spawnUnits(hexManager);
        turnState = TurnState.getInstance();
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
