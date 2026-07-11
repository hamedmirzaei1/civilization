package ap.project.civilization.model.world.unit.units;

import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.model.world.unit.core.UnitType;

public class Worker extends Unit {
    private boolean employed;

    private int maxAP;
    private final int reducedMaxAP = UnitType.WORKER.getMaxAP() - 4;
    public Worker(Hex currentHex, double x, double y) {
        super(currentHex, UnitType.WORKER, x, y);
        employed = false;
        maxAP = UnitType.WORKER.getMaxAP();
    }

    @Override
    public void getFocus() {
        if(!employed) {
            super.getFocus();
        }
    }

    public boolean isEmployed() {
        return employed;
    }

    public void setEmployed(boolean employed) {
        this.employed = employed;
        if(employed) {
            maxAP = reducedMaxAP;
            if(getAp() > maxAP) {
                setAP(reducedMaxAP);
            }
        } else {
            maxAP = UnitType.WORKER.getMaxAP();
        }
    }

    public int getMaxAP() {
        return maxAP;
    }

    @Override
    public void reviveAP() {
        setAP(maxAP);
    }
}
