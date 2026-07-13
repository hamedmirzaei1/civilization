package ap.project.civilization.controller.ui;

import ap.project.civilization.view.GamePanel;
import ap.project.civilization.view.render.ui.components.UIButton;
import ap.project.civilization.view.render.ui.panels.EndTurnButton;
import ap.project.civilization.view.render.ui.panels.ItemMenu;

import java.awt.event.MouseEvent;

public class ButtonController {
    private final EndTurnButton endTurnButton;
    private final ItemMenu itemMenu;

    private final MenuController menuController;
    private final SelectionController selectionController;

    public ButtonController(GamePanel view, ItemMenu itemMenu, MenuController menuController, SelectionController selectionController) {
        endTurnButton = new EndTurnButton(() -> {});
        view.getRenderer().getUiRenderer().setEndTurnButton(endTurnButton);
        this.itemMenu = itemMenu;
        this.menuController = menuController;
        this.selectionController = selectionController;
    }

    public boolean handleClick(MouseEvent e) {
        if(endTurnButton.contains(e.getX(), e.getY())) {
            endTurnButton.click();
            selectionController.unSelect();
            return true;
        }

        if(itemMenu.isVisible()) {
            for (UIButton btn : itemMenu.getButtons()) {
                if (btn.contains(e.getX(), e.getY())) {
                    btn.click();
                    menuController.hideMenu();
                    selectionController.unSelect();
                    return true;
                }
            }
        }
        return false;
    }
}
