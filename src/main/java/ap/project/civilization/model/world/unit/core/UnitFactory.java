package ap.project.civilization.model.world.unit.core;

import ap.project.civilization.model.gamestate.TurnState;
import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.hex.hexes.TownHall;
import ap.project.civilization.model.world.unit.UnitManager;
import ap.project.civilization.model.world.unit.movement.MoveTools;

import java.util.HashMap;
import java.util.LinkedList;

public class UnitFactory {
    private final UnitManager unitManager;
    private final HexManager hexManager;

    private final HashMap<Integer, LinkedList<UnitType>> creatingQueue;

    public UnitFactory(UnitManager unitManager, HexManager hexManager) {
        this.unitManager = unitManager;
        this.hexManager = hexManager;
        creatingQueue = new HashMap<>();
        creatingQueue.put(1, new LinkedList<>());
    }

    public void createUnit(UnitType unitType, Hex location) {
        Unit unit = unitType.create(location,
                hexManager.getPixelCoords().get(location).x,
                hexManager.getPixelCoords().get(location).y);

        unitManager.addUnit(unit, location);
        MoveTools.positionUnit(unit, hexManager, 1);
        TownHall.getInstance().addUnit();
    }

    public void addToQueue(UnitType type) {
        creatingQueue.get(TurnState.getInstance().getTurn()).add(type);
    }

    public void resolveTurn() {
        int comingTurn = TurnState.getInstance().getTurn()+1;
        for(Integer turn : creatingQueue.keySet()) {
            for (int i=0; i<creatingQueue.get(turn).size(); i++) {
                UnitType type = creatingQueue.get(turn).get(i);
                if(type.getSpawningTime() <= comingTurn-turn) {
                    createUnit(type, TownHall.getInstance());
                    creatingQueue.get(turn).remove(type);
                    i--;
                }
            }
        }
        creatingQueue.put(comingTurn, new LinkedList<>());
    }
}
