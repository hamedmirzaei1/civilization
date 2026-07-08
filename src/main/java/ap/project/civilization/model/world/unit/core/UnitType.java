package ap.project.civilization.model.world.unit.core;

import ap.project.civilization.model.world.hex.Hex;
import ap.project.civilization.model.world.unit.units.BorderExpander;
import ap.project.civilization.model.world.unit.units.Builder;
import ap.project.civilization.model.world.unit.units.Explorer;
import ap.project.civilization.view.util.game.GameColors;

import java.awt.*;

public enum UnitType {
    EXPLORER(GameColors.EXPLORER_UNIT, "E") {
        @Override
        public Unit create(Hex hex, double x, double y) {
            return new Explorer(hex, x, y);
        }
    },
    BORDER_EXPANDER(GameColors.BORDER_EXPANDER_UNIT, "Bo") {
        @Override
        public Unit create(Hex hex, double x, double y) {
            return new BorderExpander(hex, x, y);
        }
    },
    BUILDER(GameColors.BUILDER_UNIT, "Bu") {
        @Override
        public Unit create(Hex hex, double x, double y) {
            return new Builder(hex, x, y);
        }
    };
//    WORKER;

    public abstract Unit create(Hex hex, double x, double y);

    private final Color color;
    private final String text;

    UnitType(Color color, String text) {
        this.color = color;
        this.text = text;
    }

    public Color getColor() {
        return color;
    }

    public String getText() {
        return text;
    }
}
