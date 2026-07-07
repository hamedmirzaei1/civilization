package ap.project.civilization.model.unit;

import ap.project.civilization.model.hex.HexManager;

import java.util.ArrayList;
import java.util.List;

public class UnitManager {
    private List<Unit> units;

    private final UnitFactory unitFactory;

    public UnitManager(HexManager hexManager) {
        units = new ArrayList<>();

        unitFactory = new UnitFactory(this);
        spawnUnits(hexManager);
    }

    public List<Unit> getUnits() {
        return units;
    }
    public void addUnit(Unit unit) {
        units.add(unit);
    }

    private void spawnUnits(HexManager hexManager) {
        unitFactory.createUnit(UnitType.EXPLORER, hexManager.getTownHall());
    }
}
