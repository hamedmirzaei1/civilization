package ap.project.civilization.view;

import ap.project.civilization.controller.GameController;
import ap.project.civilization.view.render.Renderer;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final Renderer renderer;

    public GamePanel(GameController controller) {
        renderer = new Renderer(controller.getModel());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        renderer.render((Graphics2D) g);
    }
}
