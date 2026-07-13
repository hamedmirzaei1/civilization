package ap.project.civilization.view.render.ui.components;

import ap.project.civilization.view.util.ui.UIColors;

import java.awt.*;

public abstract class UIPanel {
    protected final Rectangle bounds;
    private boolean visible;

    protected final int padding;
    protected final int spacing;

    private final Stroke NORMAL = new BasicStroke(4);

    protected UIPanel(Rectangle bounds, int padding, int spacing) {
        this.bounds = bounds;
        this.padding = padding;
        this.spacing = spacing;

        visible = false;
    }

    public abstract void render(Graphics2D g2d, int panelWidth, int panelHeight);
    public abstract void drawComponents(Graphics2D g2d);
    public abstract void updatePanel(int panelWidth, int panelHeight);

    public void drawPanel(Graphics2D g2d) {
        g2d.setColor(UIColors.LIGHT_MENU_BACKGROUND);
        g2d.fillRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, 10, 10);

        g2d.setColor(UIColors.LIGHT_MENU_BORDER);
        g2d.setStroke(NORMAL);
        g2d.drawRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, 10, 10);
    }

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
