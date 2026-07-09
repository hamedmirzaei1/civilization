package ap.project.civilization.model.world.building;

import ap.project.civilization.model.world.hex.terrain.Terrain;

public class BuildingFactory {
    public static void createBuilding(Terrain terrain, BuildingType type) {
        Building building = new ProductionBuilding(type, terrain);
        terrain.setBuilding(building);
    }
}
