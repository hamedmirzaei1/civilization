package ap.project.civilization.view.render.ui;

import ap.project.civilization.controller.core.GameController;
import ap.project.civilization.view.GamePanel;
import ap.project.civilization.view.render.Camera;
import ap.project.civilization.view.render.Renderable;
import ap.project.civilization.view.render.ui.panels.ItemMenu;

import java.awt.*;

public class UIRenderer implements Renderable {
    private final ItemMenu selectionMenu;

    private final GamePanel view;
    public UIRenderer(GamePanel view) {
        this.view = view;
        selectionMenu = new ItemMenu();
    }

    @Override
    public void render(Graphics2D g2d, Camera camera) {
        selectionMenu.updateLayout(view.getWidth(), view.getHeight());
        selectionMenu.render(g2d);
    }

    public ItemMenu getSelectionMenu() {
        return selectionMenu;
    }

}
