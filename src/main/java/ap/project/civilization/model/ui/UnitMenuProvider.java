package ap.project.civilization.model.ui;

import ap.project.civilization.model.unit.core.Unit;

import java.util.ArrayList;
import java.util.List;

public class UnitMenuProvider implements MenuProvider<Unit> {

    @Override
    public MenuModel createMenu(Unit unit) {
        List<String> details = new ArrayList<>();
        details.add(unit.getType().name());

        List<MenuAction> actions = new ArrayList<>();

        return new MenuModel(details, actions);
    }
}
