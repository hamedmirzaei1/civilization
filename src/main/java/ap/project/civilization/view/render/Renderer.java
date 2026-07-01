package ap.project.civilization.view.render;

import ap.project.civilization.model.GameModel;
import ap.project.civilization.view.Camera;

import java.awt.*;

public class Renderer implements Renderable{
    private GameModel model;
    private HexRenderer hexRenderer;

    public Renderer(GameModel model) {
        this.model = model;
        hexRenderer = new HexRenderer(model);
    }

    @Override
    public void render(Graphics2D g2d, Camera camera) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        hexRenderer.render(g2d, camera);
    }
}
