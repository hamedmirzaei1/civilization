package ap.project.civilization.model.world.unit.movement;

import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.unit.UnitManager;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.model.world.unit.core.UnitType;

public class Move {

    public static void MoveToHex(Unit unit, Hex targetHex, HexManager hexManager, UnitManager unitManager) {
        if(unit.getAp() >= targetHex.getType().getMoveCost()) {
            if(MoveTools.moveOneHex(unit, targetHex, hexManager, unitManager)) {
                unit.reduceAP(targetHex.getType().getMoveCost());
            }
        }

    }

    public static void setNeighborsMovable(Unit unit) {
        if(unit.getCurrentHex() == null) return;
        for(Hex h : FogOfWar.neighbors(unit.getCurrentHex(), HexManager.getInstance())) {
            if(!h.isVisible() && unit.getType() != UnitType.EXPLORER) {
                continue;
            }
            if(h.getType().getMoveCost() > unit.getAp()) {
                continue;
            }

            h.setMovable(true);
        }
    }

    public static void setNeighborsUnmovable(Unit unit) {
       if(unit.getCurrentHex() == null) return;
       for(Hex h : FogOfWar.neighbors(unit.getCurrentHex(), HexManager.getInstance())) {
           h.setMovable(false);
       }
    }
}
