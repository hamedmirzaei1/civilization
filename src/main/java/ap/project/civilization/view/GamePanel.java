package ap.project.civilization.view;

import ap.project.civilization.controller.GameController;
import ap.project.civilization.model.hex.HexManager;
import ap.project.civilization.view.render.MakeHex;
import ap.project.civilization.view.render.Renderer;
import ap.project.civilization.view.util.GameColors;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class GamePanel extends JPanel {
    private final Renderer renderer;
    private final Camera camera;

    public GamePanel(GameController controller) {
        renderer = new Renderer(controller.getModel());
        camera = new Camera();
        setPanel(controller);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        renderer.render((Graphics2D) g, camera);
    }

    private void setPanel(GameController controller) {
        setBackground(GameColors.BACKGROUND);
        camera.centerOnWorld(controller.getModel().getHexManager());
    }

    public Camera getCamera() {
        return camera;
    }
}
