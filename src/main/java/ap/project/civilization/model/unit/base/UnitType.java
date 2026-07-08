package ap.project.civilization.model.unit.base;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.unit.units.BorderExpander;
import ap.project.civilization.model.unit.units.Explorer;

public enum UnitType {
    EXPLORER {
        @Override
        public Unit create(Hex hex, double x, double y) {
            return new Explorer(hex, x, y);
        }
    },
    BORDER_EXPANDER {
        @Override
        public Unit create(Hex hex, double x, double y) {
            return new BorderExpander(hex, x, y);
        }
    };
//    BUILDER,
//    WORKER;

    public abstract Unit create(Hex hex, double x, double y);
}
