package ap.project.civilization.model.gamestate;

import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.unit.UnitManager;

public class TurnState {
    private static TurnState instance;

    private TurnState(){
        turn = 1;
        turnResolve = new TurnResolve(HexManager.getInstance(), UnitManager.getInstance(), this);
    }

    public static TurnState getInstance() {
        if(instance == null) {
            instance = new TurnState();
        }
        return instance;
    }

    private int turn;
    private TurnResolve turnResolve;

    public int getTurn() {
        return turn;
    }
    public void nextTurn() {
        System.out.println("next turn");
        turnResolve.resolveTurn();
        turn++; // must be the last statement
    }
}
