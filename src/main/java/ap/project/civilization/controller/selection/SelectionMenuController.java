package ap.project.civilization.controller.selection;

import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.ui.menuproviders.HexMenuProvider;
import ap.project.civilization.model.ui.MenuModel;
import ap.project.civilization.model.ui.menuproviders.UnitMenuProvider;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.view.render.ui.components.UIButton;
import ap.project.civilization.view.render.ui.panels.ItemMenu;

import java.awt.event.MouseEvent;

public class SelectionMenuController {
    private final ItemMenu menu;

    private final HexMenuProvider hexProvider;
    private final UnitMenuProvider unitProvider;

    public SelectionMenuController(ItemMenu menu) {
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

    public boolean handleButtons(MouseEvent e) {
        if(!menu.isVisible()) return false;

        for(UIButton btn : menu.getButtons()) {
            if(btn.contains(e.getX(), e.getY())) {
                btn.click();
                hideMenu();
                return true;
            }
        }
        return false;
    }
}
