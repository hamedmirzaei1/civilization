package ap.project.civilization.model.gamestate;

import ap.project.civilization.model.world.building.BuildingType;
import ap.project.civilization.model.world.building.ProductionBuilding;
import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.unit.UnitManager;
import ap.project.civilization.model.world.unit.core.Unit;

public class TurnResolve {
    private HexManager hexManager;
    private UnitManager unitManager;

    public TurnResolve(HexManager hexManager, UnitManager unitManager, TurnState turnState) {
        this.hexManager = hexManager;
        this.unitManager = unitManager;
    }

    public void resolveTurn() {
        reviveUnits();
        unitManager.getUnitFactory().resolveTurn();
        produce();
    }

    private void reviveUnits() {
        for(Unit unit : unitManager.getUnits()) {
            unit.reviveAP();
        }
    }

    private void consumeUpkeep() {

    }

    private void produce() {
        for(Hex hex : hexManager.getHexes()) {
            if(!hex.isUnlock()) continue;
            if(!hex.hasBuilding()) continue;
            if(hex.getBuilding().getType() == BuildingType.TOWN ||
                    hex.getBuilding().getType() == BuildingType.TOWN_HALL) continue;

            ((ProductionBuilding)hex.getBuilding()).produce();
        }
    }
}
