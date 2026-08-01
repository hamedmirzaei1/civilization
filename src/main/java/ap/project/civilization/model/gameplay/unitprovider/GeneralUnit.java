package ap.project.civilization.model.gameplay.unitprovider;

import ap.project.civilization.model.gameplay.core.MenuAction;
import ap.project.civilization.model.gameplay.core.MenuModel;
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
