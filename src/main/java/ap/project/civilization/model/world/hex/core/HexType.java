package ap.project.civilization.model.world.hex.core;

import ap.project.civilization.model.SelectableType;
import ap.project.civilization.view.util.game.GameColors;

import java.awt.*;

public enum HexType implements SelectableType {
    FOREST(GameColors.FOREST_TERRAIN, "Forest"),
    PLAIN(GameColors.PLAIN_TERRAIN, "Plain"),
    MOUNTAIN(GameColors.MOUNTAIN_TERRAIN, "Mountain"),
    LAWN(GameColors.LAWN_TERRAIN, "Lawn"),
    TOWN_HALL(GameColors.TOWN_HALL, "Town Hall");

    private final Color color;
    private final String displayName;

    HexType(Color color, String displayName) {
        this.color = color;
        this.displayName = displayName;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
