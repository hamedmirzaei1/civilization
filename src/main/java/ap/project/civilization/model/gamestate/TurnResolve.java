package ap.project.civilization.model.gamestate;

import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.unit.UnitManager;

public class TurnResolve {
    private HexManager hexManager;
    private UnitManager unitManager;

    public TurnResolve(HexManager hexManager, UnitManager unitManager) {
        this.hexManager = hexManager;
        this.unitManager = unitManager;
    }

    public void resolveTurn() {

    }
}
