package ap.project.civilization.model.world.resource;

public enum Resource {
    FOOD("Food"),
    WOOD("Wood"),
    STONE("Stone"),
    IRON("Iron");

    private String displayName;

    Resource(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
