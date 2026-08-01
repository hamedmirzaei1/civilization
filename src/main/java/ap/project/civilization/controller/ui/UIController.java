package ap.project.civilization.controller.ui;

import ap.project.civilization.model.GameModel;
import ap.project.civilization.view.GamePanel;
import ap.project.civilization.view.render.ui.panels.ItemMenu;

import java.awt.event.MouseEvent;

public class UIController {
    private final ButtonController buttonController;
    private final SelectionController selectionController;
    private final MenuController menuController;

    private final UpdateHUD updateHud;

    public UIController(GamePanel view, GameModel model) {
        ItemMenu itemMenu = view.getRenderer().getUiRenderer().getItemMenu();
        menuController = new MenuController(itemMenu);

        this.selectionController = new SelectionController(model, view, view.getCamera(), menuController);
        this.buttonController = new ButtonController(view, itemMenu, menuController, selectionController);
        updateHud = new UpdateHUD(view);
    }

    public void onMouseClicked(MouseEvent e) {
        if(buttonController.handleClick(e)) return;

        selectionController.handleClick(e);
    }

    public UpdateHUD getHudController() {
        return updateHud;
    }
}
