package ap.project.civilization.model.world.unit.units;

import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.model.world.unit.UnitManager;
import ap.project.civilization.model.world.unit.core.UnitType;
import ap.project.civilization.model.world.unit.movement.FogOfWar;
import ap.project.civilization.model.world.unit.movement.MoveTools;
import ap.project.civilization.model.util.ModelConstants;

public class Explorer extends Unit {

    public Explorer(Hex location, double x, double y) {
        super(location, UnitType.EXPLORER, x, y);
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
