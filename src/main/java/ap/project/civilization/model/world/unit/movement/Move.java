package ap.project.civilization.model.world.unit.movement;

import ap.project.civilization.model.gamestate.Technology;
import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.hexes.HexType;
import ap.project.civilization.model.world.unit.UnitManager;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.model.world.unit.core.UnitType;

import static ap.project.civilization.model.util.ModelConstants.SEA_MOVE_COST;

public class Move {

    public static void MoveToHex(Unit unit, Hex targetHex, HexManager hexManager, UnitManager unitManager) {
        int cost = effectiveMoveCost(targetHex);
        if(unit.getAp() >= cost) {
            if(MoveTools.moveOneHex(unit, targetHex, hexManager, unitManager)) {
                unit.reduceAP(cost);
            }
        }

    }

    public static void setNeighborsMovable(Unit unit) {
        if(unit.getCurrentHex() == null) return;
        for(Hex h : FogOfWar.neighbors(unit.getCurrentHex(), HexManager.getInstance())) {
            if(!h.isVisible() && unit.getType() != UnitType.EXPLORER) {
                continue;
            }
            int cost = effectiveMoveCost(h);
            if(cost > unit.getAp() || cost == -1) {
                continue;
            }
            if(!Slot.hasEmptySlot(h, UnitManager.getInstance())) {
                continue;
            }
            h.setMovable(true);
        }
    }

    private static int effectiveMoveCost(Hex hex) {
        if(hex.getType() == HexType.SEA && Technology.sailing.isUnlocked()) {
            return SEA_MOVE_COST;
        }
        return hex.getType().getMoveCost();
    }

    public static void setNeighborsUnmovable(Unit unit) {
        if(unit.getCurrentHex() == null) return;
        for(Hex h : FogOfWar.neighbors(unit.getCurrentHex(), HexManager.getInstance())) {
           h.setMovable(false);
        }
    }

    public static void setAllUnmovable() {
        for(Hex h : HexManager.getInstance().getHexes()) {
            h.setMovable(false);
        }
    }
}
