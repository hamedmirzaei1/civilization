package ap.project.civilization.model.world.building;

import ap.project.civilization.model.world.hex.hexes.Terrain;
import ap.project.civilization.model.world.hex.hexes.TownHall;
import ap.project.civilization.model.world.resource.Inventory;

public class ProductionBuilding extends Building {
    private boolean active;
    private int productionRate;

    public ProductionBuilding(BuildingType type, Terrain terrain) {
        super(type, terrain);

        active = false;
        this.productionRate = type.getProducingRate();
    }

    public void produce() {
        Inventory inventory = ((Terrain)getHex()).getInventory();
        if(inventory.Contains(getType().getResource()) &&
                inventory.remove(getType().getResource(), productionRate)) {
            TownHall.getInstance().getWarehouse().add(getType().getResource(), productionRate);
        }
    }
}
