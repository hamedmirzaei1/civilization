package ap.project.civilization.model.world.unit.units;

import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.model.world.unit.UnitManager;
import ap.project.civilization.model.world.unit.core.UnitType;
import ap.project.civilization.model.world.unit.movement.MoveTools;

public class Builder extends Unit {

    public Builder(Hex currentHex, double x, double y) {
        super(currentHex, UnitType.BUILDER, x, y);
    }


}
