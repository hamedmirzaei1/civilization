package ap.project.civilization.view.render.ui;

import ap.project.civilization.view.GamePanel;
import ap.project.civilization.view.render.Camera;
import ap.project.civilization.view.render.Renderable;
import ap.project.civilization.view.render.ui.panels.ItemMenu;

import java.awt.*;

public class UIRenderer implements Renderable {
    private final ItemMenu itemMenu;

    private final GamePanel view;
    public UIRenderer(GamePanel view) {
        this.view = view;
        itemMenu = new ItemMenu();
    }

    @Override
    public void render(Graphics2D g2d, Camera camera) {
        itemMenu.render(g2d, view.getWidth(), view.getHeight());
    }

    public ItemMenu getItemMenu() {
        return itemMenu;
    }

}
