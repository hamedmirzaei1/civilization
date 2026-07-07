package ap.project.civilization.model.unit.base;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.hex.HexManager;
import ap.project.civilization.model.unit.movement.MoveUnit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UnitManager {
    private List<Unit> units;
    private final HashMap<Hex, List<Unit>> hexUnitData;

    private final UnitFactory unitFactory;

    public UnitManager(HexManager hexManager) {
        units = new ArrayList<>();
        hexUnitData = new HashMap<>();
        for(Hex hex : hexManager.getHexes()) {
            hexUnitData.put(hex, new ArrayList<>());
        }

        unitFactory = new UnitFactory(this, hexManager);
        spawnUnits(hexManager);
    }

    public List<Unit> getUnits() {
        return units;
    }

    public HashMap<Hex, List<Unit>> getHexUnitData() {
        return hexUnitData;
    }

    public void changeHexLocation(Unit unit, Hex currentHex, Hex targetHex) {
        hexUnitData.get(currentHex).remove(unit);
        hexUnitData.get(targetHex).add(unit);
    }

    public void addUnit(Unit unit, Hex hex) {
        units.add(unit);
        hexUnitData.get(hex).add(unit);
    }
    private void spawnUnits(HexManager hexManager) {
        Unit unit = unitFactory.createUnit(UnitType.EXPLORER, hexManager.getTownHall());
    }

    public void update() {
        for(Unit unit : units) {
            unit.update(this);
        }
    }

}
