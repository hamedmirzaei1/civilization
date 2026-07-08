package ap.project.civilization.model.unit.units;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.hex.HexManager;
import ap.project.civilization.model.unit.core.Unit;
import ap.project.civilization.model.unit.core.UnitManager;
import ap.project.civilization.model.unit.core.UnitType;
import ap.project.civilization.model.unit.movement.MoveTools;

import static ap.project.civilization.model.util.ModelConstants.BORDER_EXPANDER_AP;

public class BorderExpander extends Unit {
    public BorderExpander(Hex currentHex, double x, double y) {
        super(currentHex, UnitType.BORDER_EXPANDER, BORDER_EXPANDER_AP, BORDER_EXPANDER_AP, x, y);
    }

    @Override
    public void arrive() {
        super.arrive();
        if(!getCurrentHex().isUnlock()) getCurrentHex().setUnlock(true);
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
