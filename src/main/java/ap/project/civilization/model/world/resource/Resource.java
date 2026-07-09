package ap.project.civilization.model.world.resource;


import ap.project.civilization.model.world.building.BuildingType;

import java.util.Set;

public enum Resource {
    FOOD("Food", Set.of(BuildingType.FARM, BuildingType.STABLE)),
    WOOD("Wood", Set.of(BuildingType.LUMBER_MILL)),
    STONE("Stone", Set.of(BuildingType.STONE_MINE)),
    IRON("Iron", Set.of(BuildingType.IRON_MINE));

    private final String displayName;
    private final Set<BuildingType> suitableBuilding;

    Resource(String displayName, Set<BuildingType> suitableBuilding) {
        this.displayName = displayName;
        this.suitableBuilding = suitableBuilding;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Set<BuildingType> getSuitableBuilding() {
        return suitableBuilding;
    }
}
