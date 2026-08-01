package ap.project.civilization.model.world.unit.core;

import ap.project.civilization.view.util.game.GameColors;

import java.awt.*;

public enum UnitDisplayComponent {
    EXPLORER(GameColors.EXPLORER_UNIT, "E", "Explorer"),
    BORDER_EXPANDER(GameColors.BORDER_EXPANDER_UNIT, "Bo","Border Expander"),
    BUILDER(GameColors.BUILDER_UNIT, "Bu", "Builder"),
    WORKER(GameColors.WORKER_UNIT, "W", "Worker")
    ;

    private final Color color;
    private final String text;
    private final String displayName;

    UnitDisplayComponent(Color color, String text, String displayName) {
        this.color = color;
        this.text = text;
        this.displayName = displayName;
    }

    public Color getColor() {
        return color;
    }

    public String getText() {
        return text;
    }

    public String getDisplayName() {
        return displayName;
    }
}
