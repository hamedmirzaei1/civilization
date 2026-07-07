package ap.project.civilization.model.unit.units;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.unit.base.Unit;
import ap.project.civilization.model.unit.base.UnitType;
import ap.project.civilization.model.util.ModelConstants;

public class Explorer extends Unit {
    public Explorer(Hex location, double x, double y) {
        super(location, UnitType.EXPLORER, ModelConstants.EXPLORER_AP, ModelConstants.EXPLORER_AP, x, y);
    }
}
