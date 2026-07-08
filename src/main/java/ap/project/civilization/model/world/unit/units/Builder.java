package ap.project.civilization.model.world.unit.units;

import ap.project.civilization.model.world.hex.Hex;
import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.model.world.unit.core.UnitManager;
import ap.project.civilization.model.world.unit.core.UnitType;
import ap.project.civilization.model.world.unit.movement.MoveTools;
import ap.project.civilization.model.util.ModelConstants;

public class Builder extends Unit {

    public Builder(Hex currentHex, double x, double y) {
        super(currentHex, UnitType.BUILDER, ModelConstants.BUILDER_AP, ModelConstants.BUILDER_AP, x, y);
    }

    @Override
    public void getFocus() {
        MoveTools.setNeighborsMovable(this, true);
    }

    @Override
    public void getApproach(Hex selectedHex) {
        MoveTools.moveToHex(this, selectedHex, HexManager.getInstance(), UnitManager.getInstance());
        MoveTools.setNeighborsMovable(this, false);
    }
}
