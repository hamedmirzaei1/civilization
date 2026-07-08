package ap.project.civilization.model.unit.units;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.hex.HexManager;
import ap.project.civilization.model.unit.base.Unit;
import ap.project.civilization.model.unit.base.UnitManager;
import ap.project.civilization.model.unit.base.UnitType;
import ap.project.civilization.model.unit.movement.FogOfWar;
import ap.project.civilization.model.unit.movement.MoveUnit;
import ap.project.civilization.model.util.ModelConstants;

public class Explorer extends Unit {

    public Explorer(Hex location, double x, double y) {
        super(location, UnitType.EXPLORER, ModelConstants.EXPLORER_AP, ModelConstants.EXPLORER_AP, x, y);
        arrive();
    }


    @Override
    public void arrive() {
        super.arrive();
        for(Hex hex : FogOfWar.neigbors(getCurrentHex(), HexManager.getInstance())) {
            hex.setVisible(true);
        }
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
