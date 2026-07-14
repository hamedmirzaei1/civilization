package ap.project.civilization.model.gamestate;

import ap.project.civilization.model.util.ModelConstants;
import ap.project.civilization.model.world.building.BuildingType;
import ap.project.civilization.model.world.building.ProductionBuilding;
import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.hexes.TownHall;
import ap.project.civilization.model.world.resource.Resource;
import ap.project.civilization.model.world.unit.UnitManager;
import ap.project.civilization.model.world.unit.core.Unit;

public class TurnResolve {
    private final HexManager hexManager;
    private final UnitManager unitManager;

    public TurnResolve(HexManager hexManager, UnitManager unitManager, TurnState turnState) {
        this.hexManager = hexManager;
        this.unitManager = unitManager;
    }

    public void resolveTurn() {
        reviveUnits();
        unitManager.getUnitFactory().resolveTurn();
        produce();
        consumeUpkeep();
    }

    private void reviveUnits() {
        for(Unit unit : unitManager.getUnits()) {
            unit.reviveAP();
        }
    }

    private void consumeUpkeep() {
        TownHall.getInstance().getWarehouse().remove(Resource.FOOD,
                unitManager.getUnits().size() * ModelConstants.FOOD_CONSUME_PER_UNIT);

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
