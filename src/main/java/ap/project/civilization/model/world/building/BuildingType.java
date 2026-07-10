package ap.project.civilization.model.world.building;

import ap.project.civilization.model.world.resource.Resource;
import ap.project.civilization.view.util.game.AssetManager;

import java.awt.image.BufferedImage;

import static ap.project.civilization.model.util.ModelConstants.*;

public enum BuildingType {
    LUMBER_MILL("Lumber Mill", Resource.WOOD, LUMBER_MILl_RATE),
    STONE_MINE("Stone Mine", Resource.STONE, STONE_MINE_RATE),
    IRON_MINE("Iron Mine", Resource.IRON, IRON_MINE_RATE),
    FIELD("Field", Resource.FOOD, FARM_RATE),
    STABLE("Stable", Resource.FOOD, STABLE_RATE),

    TOWN_HALL("Town Hall Building", null, 0),
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

    public BufferedImage getAsset() {
        return AssetManager.get(this.name());
    }
}
