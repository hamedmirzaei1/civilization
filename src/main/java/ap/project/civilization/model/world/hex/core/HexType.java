package ap.project.civilization.model.world.hex.core;

import ap.project.civilization.model.SelectableType;
import ap.project.civilization.model.world.resource.Resource;
import ap.project.civilization.view.util.game.GameColors;

import java.awt.*;
import java.util.Set;

public enum HexType implements SelectableType {
    FOREST(GameColors.FOREST_TERRAIN, "Forest", Set.of(Resource.WOOD)),
    PLAIN(GameColors.PLAIN_TERRAIN, "Plain", Set.of(Resource.FOOD)),
    MOUNTAIN(GameColors.MOUNTAIN_TERRAIN, "Mountain", Set.of(Resource.STONE, Resource.IRON)),
    LAWN(GameColors.LAWN_TERRAIN, "Lawn", Set.of(Resource.FOOD)),
    TOWN_HALL(GameColors.TOWN_HALL, "Town Hall", Set.of());

    private final Color color;
    private final String displayName;
    private final Set<Resource> resources;

    HexType(Color color, String displayName, Set<Resource> resources) {
        this.color = color;
        this.displayName = displayName;
        this.resources = resources;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    public Set<Resource> getResources() {
        return resources;
    }

    public boolean hasResource(Resource resource) {
        for(Resource r : this.resources) {
            if(r == resource) return true;
        }
        return false;
    }
}
