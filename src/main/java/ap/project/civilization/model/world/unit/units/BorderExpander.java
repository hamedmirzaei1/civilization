package ap.project.civilization.model.world.unit.units;

import ap.project.civilization.model.util.ModelConstants;
import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.model.world.unit.UnitManager;
import ap.project.civilization.model.world.unit.core.UnitType;
import ap.project.civilization.model.world.unit.movement.Move;
import ap.project.civilization.model.world.unit.movement.MoveTools;

public class BorderExpander extends Unit {
    public BorderExpander(Hex currentHex, double x, double y) {
        super(currentHex, UnitType.BORDER_EXPANDER, x, y);
    }

    public void resolveExpand() {
        reduceAP(ModelConstants.EXPANDING_COST_AP);
    }
}
