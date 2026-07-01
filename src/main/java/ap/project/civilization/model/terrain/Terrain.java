package ap.project.civilization.model.terrain;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.hex.HexCoord;

public abstract class Terrain extends Hex {
    private boolean visible;

    public Terrain(HexCoord coordinate) {
        super(coordinate);

        visible = false;
    }

    public boolean isVisible() {
        return visible;
    }
}
