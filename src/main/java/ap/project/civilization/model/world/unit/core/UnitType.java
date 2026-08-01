package ap.project.civilization.model.world.unit.core;

import ap.project.civilization.model.util.ModelConstants;
import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.unit.units.BorderExpander;
import ap.project.civilization.model.world.unit.units.Builder;
import ap.project.civilization.model.world.unit.units.Explorer;
import ap.project.civilization.model.world.unit.units.Worker;
import ap.project.civilization.view.util.game.GameColors;

import java.awt.*;

public enum UnitType {
    EXPLORER(UnitDisplayComponent.EXPLORER, ModelConstants.EXPLORER_AP, 3) {
        @Override
        public Unit create(Hex hex, double x, double y) {
            return new Explorer(hex, x, y);
        }
    },
    BORDER_EXPANDER(UnitDisplayComponent.BORDER_EXPANDER, ModelConstants.BORDER_EXPANDER_AP, 2) {
        @Override
        public Unit create(Hex hex, double x, double y) {
            return new BorderExpander(hex, x, y);
        }
    },
    BUILDER(UnitDisplayComponent.BUILDER, ModelConstants.BUILDER_AP, 4) {
        @Override
        public Unit create(Hex hex, double x, double y) {
            return new Builder(hex, x, y);
        }
    },
    WORKER(UnitDisplayComponent.WORKER, ModelConstants.WORKER_AP, 1) {
        public Unit create(Hex hex, double x, double y) {
            return new Worker(hex, x, y);
        }
    };

    public abstract Unit create(Hex hex, double x, double y);

    private final int maxAP;
    private final int spawningTime;
    private final UnitDisplayComponent displayComponent;

    UnitType(UnitDisplayComponent displayComponent, int maxAP, int spawningTime) {
        this.displayComponent = displayComponent;
        this.maxAP = maxAP;
        this.spawningTime = spawningTime;
    }

    public Color getColor() {
        return displayComponent.getColor();
    }

    public String getText() {
        return displayComponent.getText();
    }

    public String getDisplayName() {
        return displayComponent.getDisplayName();
    }

    public int getMaxAP() {
        return maxAP;
    }

    public int getSpawningTime() {
        return spawningTime;
    }
}
