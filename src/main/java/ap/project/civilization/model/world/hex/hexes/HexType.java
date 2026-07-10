package ap.project.civilization.model.world.hex.hexes;

import ap.project.civilization.model.world.SelectableType;
import ap.project.civilization.model.world.building.BuildingType;
import ap.project.civilization.model.world.building.BuildingType.*;
import ap.project.civilization.model.world.resource.Resource;
import ap.project.civilization.view.util.game.GameColors;

import java.awt.*;
import java.util.Set;

import static ap.project.civilization.model.util.ModelConstants.*;

public enum HexType implements SelectableType {
    FOREST(GameColors.FOREST_TERRAIN, "Forest", Set.of(Resource.WOOD), FOREST_MOVE_COST),
    PLAIN(GameColors.PLAIN_TERRAIN, "Plain", Set.of(Resource.FOOD), PLAIN_MOVE_COST),
    MOUNTAIN(GameColors.MOUNTAIN_TERRAIN, "Mountain", Set.of(Resource.STONE, Resource.IRON), MOUNTAIN_MOVE_COST),
    LAWN(GameColors.LAWN_TERRAIN, "Lawn", Set.of(Resource.FOOD), LAWN_MOVE_COST),
    TOWN_HALL(GameColors.TOWN_HALL, "Town Hall", Set.of(), TOWN_HALL_MOVE_COST);

    private final Color color;
    private final String displayName;
    private final Set<Resource> resources;
    private final int moveCost;

    HexType(Color color, String displayName, Set<Resource> resources, int moveCost) {
        this.color = color;
        this.displayName = displayName;
        this.resources = resources;
        this.moveCost = moveCost;
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

    public int getMoveCost() {
        return moveCost;
    }
}
