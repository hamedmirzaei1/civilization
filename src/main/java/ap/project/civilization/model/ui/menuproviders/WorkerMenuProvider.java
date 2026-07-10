package ap.project.civilization.model.ui.menuproviders;

import ap.project.civilization.model.ui.MenuAction;
import ap.project.civilization.model.ui.MenuModel;
import ap.project.civilization.model.world.unit.core.Unit;

import java.util.ArrayList;
import java.util.List;

public class WorkerMenuProvider implements MenuProvider<Unit> {
    @Override
    public MenuModel createMenu(Unit unit) {
        List<String> details = new ArrayList<>();
        details.add(unit.getType().getDisplayName());

        details.add("ap:  " + unit.getAp() + " of  " + unit.getType().getMaxAP());

        List<MenuAction> actions = new ArrayList<>();


        return new MenuModel(details, actions);
    }
}
