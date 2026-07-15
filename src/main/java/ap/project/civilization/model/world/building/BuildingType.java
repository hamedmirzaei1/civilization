package ap.project.civilization.model.world.building;

import ap.project.civilization.model.world.resource.Resource;
import ap.project.civilization.view.util.game.AssetManager;

import java.awt.image.BufferedImage;
import java.util.Set;

import static ap.project.civilization.model.util.ModelConstants.*;
import static ap.project.civilization.model.world.resource.Resource.*;

public enum BuildingType {
    LUMBER_MILL("Lumber Mill", WOOD, LUMBER_MILl_RATE,
            LUMBER_MILl_AP, Set.of()),
    STONE_MINE("Stone Mine", STONE, STONE_MINE_RATE,
            STONE_MINE_AP, Set.of(WOOD)),
    IRON_MINE("Iron Mine", IRON, IRON_MINE_RATE,
            IRON_MINE_AP, Set.of(WOOD, STONE)),
    FIELD("Field", FOOD, FARM_RATE,
            FARM_AP, Set.of(WOOD)),
    STABLE("Stable", FOOD, STABLE_RATE,
            STABLE_AP, Set.of(WOOD, STONE)),

    TOWN_HALL("Town Hall Building", null, 0,
            0, Set.of()),
    TOWN("Town", null, 0,
            TOWN_AP, Set.of(WOOD, STONE, IRON));



    private final Resource resource;
    private final String displayName;
    private final int producingRate;
    private final int requiredAP;

    private final Set<Resource> requiredResource;

    BuildingType(String displayName, Resource resource, int producingRate, int requiredAP, Set<Resource> requiredResource) {
        this.displayName = displayName;
        this.resource = resource;
        this.producingRate = producingRate;
        this.requiredAP = requiredAP;
        this.requiredResource = requiredResource;
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

    public Set<Resource> getRequiredResource() {
        return requiredResource;
    }
}
