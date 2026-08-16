package ap.project.civilization.model.world.hex.hexes;

import ap.project.civilization.view.util.game.GameColors;

import java.awt.*;

public enum MarginHexType {
    RIVER(GameColors.RIVER_MARGIN),
    WALL(GameColors.WALL_MARGIN);


    private Color color;

    MarginHexType(Color color) {
        this.color = color;
    }
}
