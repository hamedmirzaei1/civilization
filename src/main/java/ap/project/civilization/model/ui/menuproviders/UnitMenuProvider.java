package ap.project.civilization.model.ui.menuproviders;

import ap.project.civilization.model.ui.MenuAction;
import ap.project.civilization.model.ui.MenuModel;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.model.world.unit.core.UnitType;
import ap.project.civilization.model.world.unit.units.Builder;
import ap.project.civilization.model.world.unit.units.Worker;

import java.util.ArrayList;
import java.util.List;

public class UnitMenuProvider implements MenuProvider<Unit> {

    @Override
    public MenuModel createMenu(Unit unit) {
        List<String> details = new ArrayList<>();
        details.add(unit.getType().getDisplayName());

        details.add("ap:  " + unit.getAp() + " of  " + unit.getType().getMaxAP());

        List<MenuAction> actions = new ArrayList<>();

        if(unit.getType() == UnitType.WORKER) {
            actions.add(employButton(unit));
        }
        if(unit.getType() == UnitType.BUILDER) {

        }
        if(unit.getType() == UnitType.BORDER_EXPANDER) {

        }
        return new MenuModel(details, actions);
    }

    private MenuAction employButton(Unit unit) {
        Worker worker = (Worker)unit;
        if(((Worker) unit).isEmployed()) {
            return new MenuAction("Fire", new Runnable() {
                @Override
                public void run() {
                    worker.setEmployed(false);
                    System.out.println("fired");
                };
            });
        }
        else {
            return new MenuAction("Employ", new Runnable() {
                @Override
                public void run() {
                    worker.setEmployed(true);
                    System.out.println("employed");
                }
            });
        }
    }
}
