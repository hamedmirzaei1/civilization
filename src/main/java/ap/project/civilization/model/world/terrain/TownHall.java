package ap.project.civilization.model.world.terrain;

import ap.project.civilization.model.world.hex.Hex;
import ap.project.civilization.model.world.hex.HexCoord;
import ap.project.civilization.model.util.ModelConstants;

public class TownHall extends Hex {

    public TownHall() {
        super(new HexCoord(ModelConstants.WORLD_SIZE/2, ModelConstants.WORLD_SIZE/2));
        setUnlock(true);
        setVisible(true);
    }
}
