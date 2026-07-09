package ap.project.civilization.model.world.building;

import ap.project.civilization.model.world.hex.core.Hex;

public class Building {
    private final BuildingType type;
    private final Hex hex;

    public Building(BuildingType type, Hex hex) {
        this.type = type;
        this.hex = hex;
    }

    public BuildingType getType() {
        return type;
    }

    public Hex getHex() {
        return hex;
    }
}
