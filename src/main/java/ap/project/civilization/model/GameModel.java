package ap.project.civilization.model;

import ap.project.civilization.model.gamestate.TurnResolve;
import ap.project.civilization.model.gamestate.TurnState;
import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.unit.UnitManager;

public class GameModel {
    private final HexManager hexManager;
    private final UnitManager unitManager;
    private TurnResolve turnResolve;

    public GameModel() {
        hexManager = HexManager.getInstance();
        unitManager = UnitManager.getInstance();
        unitManager.spawnUnits(hexManager);
        TurnState turnState = TurnState.getInstance();
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
