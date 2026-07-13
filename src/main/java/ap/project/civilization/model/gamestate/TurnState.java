package ap.project.civilization.model.gamestate;

import ap.project.civilization.model.world.unit.UnitManager;

public class TurnState {
    private static TurnState instance;

    private TurnState(){
        turn = 1;
    }

    public static TurnState getInstance() {
        if(instance == null) {
            instance = new TurnState();
        }
        return instance;
    }

    private int turn;

    public int getTurn() {
        return turn;
    }
    public void nextTurn() {
        System.out.println("next turn");
        UnitManager.getInstance().getUnitFactory().resolveTurn();
        turn++; // must be the last statement
    }
}
