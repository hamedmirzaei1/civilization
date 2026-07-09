package ap.project.civilization.model.world.hex.terrain;

import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.core.HexCoord;
import ap.project.civilization.model.world.hex.core.HexType;
import ap.project.civilization.model.world.resource.Inventory;

public class Terrain extends Hex {

    private Inventory resources;
    public Terrain(HexCoord coordinate, HexType type) {
        super(coordinate, type);

        setVisible(false);

        resources = new Inventory();
    }

    public Inventory getResources() {
        return resources;
    }
}
