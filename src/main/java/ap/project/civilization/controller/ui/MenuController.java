package ap.project.civilization.controller.ui;

import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.gameplay.HexMenuProvider;
import ap.project.civilization.model.gameplay.core.MenuModel;
import ap.project.civilization.model.gameplay.core.UnitMenuProvider;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.model.world.unit.movement.Move;
import ap.project.civilization.view.render.ui.panels.ItemMenu;

public class MenuController {
    private final ItemMenu menu;

    private final HexMenuProvider hexProvider;
    private final UnitMenuProvider unitProvider;

    public MenuController(ItemMenu menu) {
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
        Move.setAllUnmovable();
    }

}
