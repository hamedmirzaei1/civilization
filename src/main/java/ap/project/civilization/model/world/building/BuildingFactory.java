package ap.project.civilization.model.world.building;

import ap.project.civilization.model.world.hex.hexes.Terrain;
import ap.project.civilization.model.world.hex.hexes.TownHall;

public class BuildingFactory {

    public static void createProductionBuilding(Terrain terrain, BuildingType type) {
        if(type == BuildingType.TOWN_HALL || type == BuildingType.TOWN) {
            throw new IllegalArgumentException("town or townhall can't be built");
        }

        Building building = new ProductionBuilding(type, terrain);
        terrain.setBuilding(building);
    }

    public static void destroyBuilding(Terrain terrain) {
        terrain.setBuilding(null); // todo : logic
    }

    public static Building createTownHallBuilding() {
        return new Building(BuildingType.TOWN_HALL, TownHall.getInstance());
    }
}
