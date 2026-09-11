package ap.project.civilization.model.gamestate;

import ap.project.civilization.model.util.ModelConstants;
import ap.project.civilization.model.world.building.BuildingType;
import ap.project.civilization.model.world.building.ProductionBuilding;
import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.resource.Resource;
import ap.project.civilization.model.world.unit.UnitManager;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.model.world.unit.core.UnitType;
import ap.project.civilization.model.world.unit.units.Worker;
import ap.project.civilization.view.navigation.components.ConfirmationDialog;

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
        CentralTransaction.getInstance().pay(new Cost().add(Resource.FOOD,
                unitManager.getUnits().size() * ModelConstants.FOOD_CONSUME_PER_UNIT));

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

    public static boolean unprocessedUnits() {
        for(Unit unit : UnitManager.getInstance().getUnits()) {
            if(unit.getType() == UnitType.WORKER) {
                if(!((Worker)unit).isEmployed()) {
                    return ConfirmationDialog.show(null, "un-employed workers. continue?");
                }
            }
            if(unit.getAp() > 0 && unit.getType() != UnitType.WORKER) {
                return ConfirmationDialog.show(null, "units have ap. continue?");
            }
        }
        return true;
    }
}
