package ap.project.civilization.model.world.unit;

import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.model.world.unit.core.UnitFactory;
import ap.project.civilization.model.world.unit.core.UnitType;
import ap.project.civilization.model.world.unit.movement.Direction;
import ap.project.civilization.model.world.unit.movement.FogOfWar;
import ap.project.civilization.model.world.unit.movement.UnitMovementUpdate;
import ap.project.civilization.model.util.ModelConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UnitManager {
    private static UnitManager instance;

    private final List<Unit> units;
    private final HashMap<Hex, List<Unit>> hexUnitData;
    private final HashMap<Hex, boolean[]> hexSlots;

    private final UnitFactory unitFactory;

    private UnitManager(HexManager hexManager) {
        units = new ArrayList<>();

        hexUnitData = new HashMap<>();
        for(Hex hex : hexManager.getHexes()) {
            hexUnitData.put(hex, new ArrayList<>());
        }

        hexSlots = new HashMap<>();
        for(Hex hex : hexManager.getHexes()) {
            hexSlots.put(hex, new boolean[ModelConstants.HEX_SLOT_NUMBER]);
        }

        unitFactory = new UnitFactory(this, hexManager);
    }

    public static UnitManager getInstance() {
        if(instance == null) {
            instance = new  UnitManager(HexManager.getInstance());
        }
        return instance;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public HashMap<Hex, List<Unit>> getHexUnitData() {
        return hexUnitData;
    }

    public void changeUnitLocation(Unit unit, Hex currentHex, Hex targetHex) {
        hexUnitData.get(currentHex).remove(unit);
        hexUnitData.get(targetHex).add(unit);
    }

    public void addUnit(Unit unit, Hex hex) {
        units.add(unit);
        hexUnitData.get(hex).add(unit);
    }
    public void consumeUnit(Unit unit) {
        units.remove(unit);
        hexUnitData.get(unit.getCurrentHex()).remove(unit);
    }

    public void spawnUnits(HexManager hexManager) {
        unitFactory.createUnit(UnitType.BUILDER, hexManager.getTownHall());
        unitFactory.createUnit(UnitType.BUILDER, hexManager.getTownHall());
        unitFactory.createUnit(UnitType.EXPLORER, hexManager.getTownHall());
        unitFactory.createUnit(UnitType.WORKER, hexManager.getTownHall());
        unitFactory.createUnit(UnitType.WORKER, hexManager.getTownHall());
    }

    public void update() {
        for(Unit unit : units) {
            UnitMovementUpdate.update(unit, this);
        }
    }

    public HashMap<Hex, boolean[]> getHexSlots() {
        return hexSlots;
    }

    public UnitFactory getUnitFactory() {
        return unitFactory;
    }

}
