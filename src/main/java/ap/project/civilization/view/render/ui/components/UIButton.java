package ap.project.civilization.view.render.ui.components;

import ap.project.civilization.view.util.ui.Fonts;
import ap.project.civilization.view.util.ui.UIColors;

import java.awt.*;

public class UIButton {
    protected final Rectangle bounds;
    private final String text;
    private final Runnable action;

    private boolean visible;

    public UIButton(Rectangle bounds, String text, Runnable action, boolean visible) {
        this.bounds = bounds;
        this.text = text;
        this.action = action;

        this.visible = visible;
    }

    public void render(Graphics2D g2d) {
        g2d.setColor(UIColors.LIGHT_MENU_BORDER);
        g2d.fillRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, 10, 10);


        g2d.setColor(UIColors.BUTTON);
        g2d.setFont(Fonts.GLOOCK(16f));
        FontMetrics fm = g2d.getFontMetrics();
        int x = bounds.x + (bounds.width - fm.stringWidth(text))/2;
        int y = bounds.y + (bounds.height + fm.getAscent())/2 - 3;

        g2d.drawString(text, x, y);
    }

    public boolean contains(int x, int y) {
        return bounds.contains(x, y);
    }

    public void click() {
        if(action != null && visible) {
            action.run();
            visible = false;
        }
    }


    public boolean isVisible() {
        return visible;
    }

    public String getText() {
        return text;
    }
}
