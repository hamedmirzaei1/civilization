package ap.project.civilization.model.world.hex.hexes;

import ap.project.civilization.model.world.building.BuildingType;
import ap.project.civilization.model.world.resource.Resource;
import ap.project.civilization.view.util.game.GameColors;

import java.awt.*;
import java.util.Set;

import static ap.project.civilization.model.util.ModelConstants.*;
import static ap.project.civilization.model.world.building.BuildingType.*;

public enum HexType {
    FOREST(GameColors.FOREST_TERRAIN, "Forest", Set.of(Resource.WOOD), FOREST_MOVE_COST, LUMBER_MILL),
    PLAIN(GameColors.PLAIN_TERRAIN, "Plain", Set.of(Resource.FOOD), PLAIN_MOVE_COST, STABLE),
    MOUNTAIN(GameColors.MOUNTAIN_TERRAIN, "Mountain", Set.of(Resource.STONE, Resource.IRON), MOUNTAIN_MOVE_COST, STONE_MINE),
    LAWN(GameColors.LAWN_TERRAIN, "Lawn", Set.of(Resource.FOOD), LAWN_MOVE_COST, FIELD),
    TOWN_HALL(GameColors.TOWN_HALL, "Town Hall", Set.of(), TOWN_HALL_MOVE_COST, BuildingType.TOWN_HALL);

    private final Color color;
    private final String displayName;
    private final Set<Resource> resources;
    private final int moveCost;

    private final BuildingType buildingType;

    HexType(Color color, String displayName, Set<Resource> resources, int moveCost, BuildingType buildingType) {
        this.color = color;
        this.displayName = displayName;
        this.resources = resources;
        this.moveCost = moveCost;
        this.buildingType = buildingType;
    }

    public Color getColor() {
        return color;
    }

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

    public BuildingType getBuildingType() {
        return buildingType;
    }
}
