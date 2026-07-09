package ap.project.civilization.model.world.building;

import ap.project.civilization.model.world.hex.terrain.Terrain;
import ap.project.civilization.model.world.hex.terrain.TownHall;

public class ProductionBuilding extends Building {
    private boolean active;
    private int productionRate;

    public ProductionBuilding(BuildingType type, Terrain terrain) {
        super(type, terrain);

        active = false;
        this.productionRate = type.getProducingRate();
    }

    public void produce() {
        if(getTerrain().getInventory().Contains(getType().getResource()) &&
                getTerrain().getInventory().remove(getType().getResource(), productionRate)) {
            TownHall.getInstance().getWarehouse().add(getType().getResource(), productionRate);
        }
    }
}
