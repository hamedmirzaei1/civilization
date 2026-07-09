package ap.project.civilization.model.world.unit.core;

import ap.project.civilization.model.world.SelectableType;
import ap.project.civilization.model.util.ModelConstants;
import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.unit.units.BorderExpander;
import ap.project.civilization.model.world.unit.units.Builder;
import ap.project.civilization.model.world.unit.units.Explorer;
import ap.project.civilization.view.util.game.GameColors;

import java.awt.*;

public enum UnitType implements SelectableType {
    EXPLORER(GameColors.EXPLORER_UNIT, "E", "Explorer", ModelConstants.EXPLORER_AP) {
        @Override
        public Unit create(Hex hex, double x, double y) {
            return new Explorer(hex, x, y);
        }
    },
    BORDER_EXPANDER(GameColors.BORDER_EXPANDER_UNIT, "Bo", "Border Expander", ModelConstants.BORDER_EXPANDER_AP) {
        @Override
        public Unit create(Hex hex, double x, double y) {
            return new BorderExpander(hex, x, y);
        }
    },
    BUILDER(GameColors.BUILDER_UNIT, "Bu", "Builder", ModelConstants.BUILDER_AP) {
        @Override
        public Unit create(Hex hex, double x, double y) {
            return new Builder(hex, x, y);
        }
    };
//    WORKER;

    public abstract Unit create(Hex hex, double x, double y);

    private final Color color;
    private final String text;
    private final String displayName;
    private final int maxAP;

    UnitType(Color color, String text, String displayName, int maxAP) {
        this.color = color;
        this.text = text;
        this.displayName = displayName;
        this.maxAP = maxAP;
    }

    public Color getColor() {
        return color;
    }

    public String getText() {
        return text;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    public int getMaxAP() {
        return maxAP;
    }
}
