package ap.project.civilization.view.render;

import ap.project.civilization.view.ui.Camera;

import java.awt.*;

public interface Renderable {
    public void render(Graphics2D g2d, Camera camera);
}
