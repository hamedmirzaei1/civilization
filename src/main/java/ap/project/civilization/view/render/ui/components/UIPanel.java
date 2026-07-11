package ap.project.civilization.view.render.ui.components;

import java.awt.*;

public abstract class UIPanel {
    protected final Rectangle bounds;
    private boolean visible;

    protected final int padding;
    protected final int spacing;

    protected UIPanel(Rectangle bounds, int padding, int spacing) {
        this.bounds = bounds;
        this.padding = padding;
        this.spacing = spacing;

        visible = false;
    }

    public abstract void render(Graphics2D g2d, int panelWidth, int panelHeight);
    public abstract void drawPanel(Graphics2D g2d);
    public abstract void drawComponents(Graphics2D g2d);

    public void show() {
        visible = true;
    }
    public void hide() {
        visible = false;
    }

    public boolean isVisible() {
        return visible;
    }
}
