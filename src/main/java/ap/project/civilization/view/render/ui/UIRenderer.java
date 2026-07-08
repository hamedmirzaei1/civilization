package ap.project.civilization.view.render.ui;

import ap.project.civilization.controller.core.GameController;
import ap.project.civilization.view.GamePanel;
import ap.project.civilization.view.render.Camera;
import ap.project.civilization.view.render.Renderable;

import java.awt.*;

public class UIRenderer implements Renderable {
    private final HexManagerMenu hexManagerMenu;

    public UIRenderer(GamePanel view) {
        hexManagerMenu = new HexManagerMenu(view);
    }
    @Override
    public void render(Graphics2D g2d, Camera camera) {
        hexManagerMenu.draw(g2d);
    }

    public void setController(GameController controller) {
        hexManagerMenu.setController(controller);
    }
}
