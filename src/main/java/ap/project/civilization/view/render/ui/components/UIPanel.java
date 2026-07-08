package ap.project.civilization.view.render.ui.components;

import java.awt.*;

public abstract class UIPanel {
    protected final Rectangle bounds;
    protected boolean visible;

    protected final int padding;
    protected final int spacing;

    protected UIPanel(Rectangle bounds, int padding, int spacing) {
        this.bounds = bounds;
        this.padding = padding;
        this.spacing = spacing;

        visible = false;
    }

    public abstract void render(Graphics2D g2d);

    public void show() {
        visible = true;
    }
    public void hide() {
        visible = false;
    }
}
