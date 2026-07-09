package ap.project.civilization.model.world.building;

import ap.project.civilization.model.util.ModelConstants;
import ap.project.civilization.model.world.resource.Resource;

import static ap.project.civilization.model.util.ModelConstants.*;

public enum BuildingType {
    LUMBER_MILL("Lumber Mill", Resource.WOOD, LUMBER_MILl_RATE),
    STONE_MINE("Stone Mine", Resource.STONE, STONE_MINE_RATE),
    IRON_MINE("Iron Mine", Resource.IRON, ModelConstants.IRON_MINE_RATE),
    FARM("Farm", Resource.FOOD, FARM_RATE),
    STABLE("Stable", Resource.FOOD, STABLE_RATE),

    TOWN("Town", null, 0);



    private final Resource resource;
    private final String displayName;
    private final int producingRate;


    BuildingType(String displayName, Resource resource, int producingRate) {
        this.displayName = displayName;
        this.resource = resource;
        this.producingRate = producingRate;
    }

    public Resource getResource() {
        return resource;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getProducingRate() {
        return producingRate;
    }
}
