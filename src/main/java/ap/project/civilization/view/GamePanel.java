package ap.project.civilization.view;

import ap.project.civilization.controller.GameController;
import ap.project.civilization.view.render.Renderer;
import ap.project.civilization.view.render.Camera;
import ap.project.civilization.view.util.MusicPlayer;
import ap.project.civilization.view.util.GameColors;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final Renderer renderer;
    private final Camera camera;
    private final MusicPlayer musicPlayer;

    public GamePanel(GameController controller) {
        renderer = new Renderer(controller, this);
        camera = new Camera();
        musicPlayer = new MusicPlayer();

        setLayout(null);
        setBackground(GameColors.BACKGROUND);
        camera.centerOnWorld();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        renderer.render((Graphics2D) g, camera);
    }

    public Camera getCamera() {
        return camera;
    }

    public MusicPlayer getMusicPlayer() {
        return musicPlayer;
    }
}
