package ap.project.civilization.view.render.ui;

import ap.project.civilization.controller.GameController;
import ap.project.civilization.view.GamePanel;
import ap.project.civilization.view.render.Camera;
import ap.project.civilization.view.render.Renderable;

import java.awt.*;

public class UIRenderer implements Renderable {
    private HexManagerMenu hexManagerMenu;

    private GameController controller;
    public UIRenderer(GameController controller, GamePanel view) {
        this.controller = controller;
        hexManagerMenu = new HexManagerMenu(view, controller);
    }
    @Override
    public void render(Graphics2D g2d, Camera camera) {
        hexManagerMenu.draw(g2d);
    }

}
