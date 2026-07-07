package ap.project.civilization.model.terrain;

import ap.project.civilization.view.util.game.GameColors;

import java.awt.*;

public enum TerrainType {
    FOREST(GameColors.FOREST_TERRAIN),
    PLAIN(GameColors.PLAIN_TERRAIN),
    MOUNTAIN(GameColors.MOUNTAIN_TERRAIN),
    LAWN(GameColors.LAWN_TERRAIN);

    private Color color;
    TerrainType(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}
