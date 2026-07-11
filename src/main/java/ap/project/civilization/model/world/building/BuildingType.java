package ap.project.civilization.model.world.building;

import ap.project.civilization.model.world.resource.Resource;
import ap.project.civilization.view.util.game.AssetManager;

import java.awt.image.BufferedImage;

import static ap.project.civilization.model.util.ModelConstants.*;

public enum BuildingType {
    LUMBER_MILL("Lumber Mill", Resource.WOOD, LUMBER_MILl_RATE, LUMBER_MILl_AP),
    STONE_MINE("Stone Mine", Resource.STONE, STONE_MINE_RATE, STONE_MINE_AP),
    IRON_MINE("Iron Mine", Resource.IRON, IRON_MINE_RATE, IRON_MINE_AP),
    FIELD("Field", Resource.FOOD, FARM_RATE, FARM_AP),
    STABLE("Stable", Resource.FOOD, STABLE_RATE, STABLE_AP),

    TOWN_HALL("Town Hall Building", null, 0, 0),
    TOWN("Town", null, 0, TOWN_AP);



    private final Resource resource;
    private final String displayName;
    private final int producingRate;
    private final int requiredAP;

    BuildingType(String displayName, Resource resource, int producingRate, int requiredAP) {
        this.displayName = displayName;
        this.resource = resource;
        this.producingRate = producingRate;
        this.requiredAP = requiredAP;
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

    public int getRequiredAP() {
        return requiredAP;
    }
}
