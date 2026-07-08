package ap.project.civilization.view;

import ap.project.civilization.controller.core.GameController;
import ap.project.civilization.model.GameModel;
import ap.project.civilization.view.render.Renderer;
import ap.project.civilization.view.render.Camera;
import ap.project.civilization.view.util.game.MusicPlayer;
import ap.project.civilization.view.util.game.GameColors;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final Renderer renderer;
    private final Camera camera;
    private final MusicPlayer musicPlayer;

    public GamePanel(GameModel model) {
        renderer = new Renderer(model, this);
        camera = new Camera(renderer);
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

    public void setController(GameController controller) {
        renderer.setController(controller);
    }

    public Renderer getRenderer() {
        return renderer;
    }

}
