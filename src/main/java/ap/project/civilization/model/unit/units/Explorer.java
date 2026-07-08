package ap.project.civilization.model.unit.units;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.hex.HexManager;
import ap.project.civilization.model.unit.core.Unit;
import ap.project.civilization.model.unit.core.UnitManager;
import ap.project.civilization.model.unit.core.UnitType;
import ap.project.civilization.model.unit.movement.FogOfWar;
import ap.project.civilization.model.unit.movement.MoveTools;
import ap.project.civilization.model.util.ModelConstants;

public class Explorer extends Unit {

    public Explorer(Hex location, double x, double y) {
        super(location, UnitType.EXPLORER, ModelConstants.EXPLORER_AP, ModelConstants.EXPLORER_AP, x, y);
    }


    @Override
    public void arrive() {
        super.arrive();
        for(Hex hex : FogOfWar.neighbors(getCurrentHex(), HexManager.getInstance())) {
            hex.setVisible(true);
        }
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
