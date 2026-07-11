package ap.project.civilization.model.gameplay.unit;

import ap.project.civilization.model.gameplay.ui.MenuAction;
import ap.project.civilization.model.gameplay.ui.MenuModel;
import ap.project.civilization.model.world.unit.core.Unit;

import java.util.ArrayList;
import java.util.List;

public class GeneralUnit {

    public MenuModel create(Unit unit) {
        List<String> details = new ArrayList<>();
        List<MenuAction> actions = new ArrayList<>();

        details.add(unit.getType().getDisplayName());
        details.add("ap:  " + unit.getAp() + " of  " + unit.getType().getMaxAP());

        addActions(unit, actions);
        addDetails(unit, details);

        return new MenuModel(details, actions);
    }

    protected void addActions(Unit unit, List<MenuAction> actions) {

    }
    protected void addDetails(Unit unit, List<String> details) {

    }
}
