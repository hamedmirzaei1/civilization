package ap.project.civilization.view.render.ui;

import ap.project.civilization.controller.core.GameController;
import ap.project.civilization.view.GamePanel;
import ap.project.civilization.view.render.Camera;
import ap.project.civilization.view.render.Renderable;

import java.awt.*;

public class UIRenderer implements Renderable {
    private final SelectionMenuView selectionMenu;

    private final GamePanel view;
    public UIRenderer(GamePanel view) {
        this.view = view;
        selectionMenu = new SelectionMenuView();
    }

    @Override
    public void render(Graphics2D g2d, Camera camera) {
        selectionMenu.updateLayout(view.getWidth(), view.getHeight());
        selectionMenu.render(g2d);
    }

    public SelectionMenuView getSelectionMenu() {
        return selectionMenu;
    }

    public void setController(GameController controller) {
    }
}
