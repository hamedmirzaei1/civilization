package ap.project.civilization.model.world.resource;


import ap.project.civilization.model.world.building.BuildingType;

import java.util.Set;

public enum Resource {
    FOOD("Food"),
    WOOD("Wood"),
    STONE("Stone"),
    IRON("Iron");

    private final String displayName;

    Resource(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
