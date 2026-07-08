package ap.project.civilization.model.unit.units;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.hex.HexManager;
import ap.project.civilization.model.unit.base.Unit;
import ap.project.civilization.model.unit.base.UnitType;
import ap.project.civilization.model.unit.movement.MoveUnit;

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
        MoveUnit.setNeighborsMovable(this, true);

    }
    @Override
    public void getApproach(Hex selectedHex) {
        MoveUnit.moveToHex(this, selectedHex, HexManager.getInstance());
        MoveUnit.setNeighborsMovable(this, false);
    }
}
