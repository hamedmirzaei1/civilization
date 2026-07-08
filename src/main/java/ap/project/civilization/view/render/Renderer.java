package ap.project.civilization.view.render;

import ap.project.civilization.controller.core.GameController;
import ap.project.civilization.model.GameModel;
import ap.project.civilization.view.GamePanel;
import ap.project.civilization.view.render.hex.HexRenderer;
import ap.project.civilization.view.render.ui.UIRenderer;
import ap.project.civilization.view.render.unit.UnitRenderer;
import ap.project.civilization.view.util.game.AssetManager;
import ap.project.civilization.view.util.ui.ViewConstants;

import java.awt.*;
import java.io.IOException;

public class Renderer implements Renderable{
    private HexRenderer hexRenderer;
    private final UnitRenderer unitRenderer;
    private UIRenderer uiRenderer;

    public Renderer(GameModel model, GamePanel view) {
        hexRenderer = new HexRenderer(model);
        unitRenderer = new UnitRenderer(model, hexRenderer);
        uiRenderer = new UIRenderer(view);

        try {
            AssetManager.loadAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        AssetManager.updateScale((int) ViewConstants.HEX_BASE_SIZE);
    }

    @Override
    public void render(Graphics2D g2d, Camera camera) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        hexRenderer.render(g2d, camera);
        unitRenderer.render(g2d, camera);
        uiRenderer.render(g2d, camera);
    }

    public void setController(GameController controller) {
        uiRenderer.setController(controller);
    }

    public HexRenderer getHexRenderer() {
        return hexRenderer;
    }

    public UIRenderer getUiRenderer() {
        return uiRenderer;
    }
}
