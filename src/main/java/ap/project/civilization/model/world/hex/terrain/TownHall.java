package ap.project.civilization.model.world.hex.terrain;

import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.core.HexCoord;
import ap.project.civilization.model.util.ModelConstants;
import ap.project.civilization.model.world.hex.core.HexType;

public class TownHall extends Hex {

    public TownHall() {
        super(new HexCoord(ModelConstants.WORLD_SIZE/2, ModelConstants.WORLD_SIZE/2), HexType.TOWN_HALL);
        setUnlock(true);
        setVisible(true);
    }
}
