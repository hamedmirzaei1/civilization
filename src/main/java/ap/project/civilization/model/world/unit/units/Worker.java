package ap.project.civilization.model.world.unit.units;

import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.model.world.unit.core.UnitType;

public class Worker extends Unit {
    private boolean employed;

    public Worker(Hex currentHex, double x, double y) {
        super(currentHex, UnitType.WORKER, x, y);
        employed = false;
    }

    public boolean isEmployed() {
        return employed;
    }

    public void setEmployed(boolean employed) {
        this.employed = employed;
    }
}
