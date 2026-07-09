package ap.project.civilization.model.world.hex.terrain;

import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.core.HexCoord;
import ap.project.civilization.model.world.hex.core.HexType;

public class Terrain extends Hex {

    public Terrain(HexCoord coordinate, HexType type) {
        super(coordinate, type);

        setVisible(false);
    }

}
