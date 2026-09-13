package ap.project.civilization.view.render.ui.components;

import ap.project.civilization.view.util.ui.Fonts;
import ap.project.civilization.view.util.ui.UIColors;

import java.awt.*;

public class UILabel {
    private final Rectangle bounds;
    private final String text;
    private final float size;
    private final Color color;

    public UILabel(Rectangle bounds, String text, float size) {
        this(bounds, text, size, UIColors.LABEL_LIGHT);
    }

    public UILabel(Rectangle bounds, String text, float size, Color color) {
        this.bounds = bounds;
        this.text = text;
        this.size = size;
        this.color = color;
    }

    public void render(Graphics2D g2d) {
        g2d.setFont(Fonts.GLOOCK(size));
        g2d.setColor(color);

        FontMetrics fm = g2d.getFontMetrics();
        int x = bounds.x + (bounds.width - fm.stringWidth(text)) / 2;
        int y = bounds.y + (bounds.height - fm.getHeight()) / 2 + fm.getAscent();

        g2d.drawString(text, x, y);
    }

    public Rectangle getBounds() {
        return bounds;
    }


}