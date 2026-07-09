package ap.project.civilization.model.world.building;

import ap.project.civilization.model.world.hex.terrain.Terrain;

public abstract class Building {
    private final BuildingType type;
    private final Terrain terrain;

    public Building(BuildingType type, Terrain terrain) {
        this.type = type;
        this.terrain = terrain;
    }

    public BuildingType getType() {
        return type;
    }

    public Terrain getTerrain() {
        return terrain;
    }
}
