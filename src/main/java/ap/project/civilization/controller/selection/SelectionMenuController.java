package ap.project.civilization.controller.selection;

import ap.project.civilization.model.world.hex.Hex;
import ap.project.civilization.model.ui.HexMenuProvider;
import ap.project.civilization.model.ui.MenuModel;
import ap.project.civilization.model.ui.UnitMenuProvider;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.view.render.ui.SelectionMenuView;

public class SelectionMenuController {
    private final SelectionMenuView menu;

    private final HexMenuProvider hexProvider;
    private final UnitMenuProvider unitProvider;

    public SelectionMenuController(SelectionMenuView menu) {
        this.menu = menu;

        hexProvider = new HexMenuProvider();
        unitProvider = new UnitMenuProvider();
    }

    public void showMenu(Hex hex) {
        MenuModel menuModel = hexProvider.createMenu(hex);
        menu.setMenu(menuModel);
    }
    public void showMenu(Unit unit) {
        MenuModel menuModel = unitProvider.createMenu(unit);
        menu.setMenu(menuModel);
    }
    public void hideMenu() {
        menu.setMenu(null);
    }
}
