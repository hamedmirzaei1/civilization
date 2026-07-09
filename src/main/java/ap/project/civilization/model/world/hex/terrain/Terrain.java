package ap.project.civilization.model.world.hex.terrain;

import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.core.HexCoord;
import ap.project.civilization.model.world.hex.core.HexType;
import ap.project.civilization.model.world.resource.Inventory;

public class Terrain extends Hex {
    private final Inventory inventory;

    public Terrain(HexCoord coordinate, HexType type) {
        super(coordinate, type);

        setVisible(false);

        inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }
}
