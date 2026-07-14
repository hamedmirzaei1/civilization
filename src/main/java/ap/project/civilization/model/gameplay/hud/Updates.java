package ap.project.civilization.model.gameplay.hud;

import ap.project.civilization.model.gameplay.ui.MenuAction;
import ap.project.civilization.model.gameplay.ui.MenuModel;
import ap.project.civilization.model.gamestate.TurnState;
import ap.project.civilization.model.world.unit.UnitManager;
import ap.project.civilization.model.world.unit.core.UnitType;

import java.util.*;

public class Updates {
    public static MenuModel create() {
        List<String> details = new ArrayList<>();
        List<MenuAction> actions = new ArrayList<>();

        details.add("Turn  " + TurnState.getInstance().getTurn());

        TreeMap<Integer, LinkedList<UnitType>> creatingQueue = UnitManager.getInstance().getUnitFactory().getCreatingQueue();

        for(int i=1; i<= TurnState.getInstance().getTurn(); i++) {
            for(UnitType type : creatingQueue.get(i)) {
                int turnLeft = type.getSpawningTime() - (TurnState.getInstance().getTurn() - i);
                details.add("Creating " + type.getDisplayName());
                if(turnLeft < 0) turnLeft = 0;
                details.add(turnLeft + " turns left");
            }
        }
        return new MenuModel(details, actions);
    }
}
