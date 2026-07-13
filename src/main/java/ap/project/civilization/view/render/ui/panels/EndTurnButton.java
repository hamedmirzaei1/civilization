package ap.project.civilization.view.render.ui.panels;

import ap.project.civilization.view.render.ui.components.UIButton;
import ap.project.civilization.view.util.ui.Fonts;
import ap.project.civilization.view.util.ui.UIColors;
import ap.project.civilization.view.util.ui.ViewConstants;

import java.awt.*;

public class EndTurnButton extends UIButton {
    private final Stroke NORMAL = new BasicStroke(5);
    public EndTurnButton(Runnable action) {

        Rectangle r = new Rectangle((int)(ViewConstants.getWindowWidth() * 0.84),
                (int)(ViewConstants.getWindowHeight() * 0.8),
                ViewConstants.getWindowWidth()/8,
                ViewConstants.getWindowWidth()/16);
        super(r, "End Turn", action, true);
    }

    @Override
    public void render(Graphics2D g2d) {
        if(!isVisible()) return;
        g2d.setColor(UIColors.HOVERED_BUTTON);
        g2d.fillRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, 30, 30);
        g2d.setColor(Color.white);
        g2d.setStroke(NORMAL);
        g2d.drawRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, 30, 30);

        g2d.setColor(Color.WHITE);
        g2d.setFont(Fonts.GLOOCK(32f));
        FontMetrics fm = g2d.getFontMetrics();
        int x = bounds.x + (bounds.width - fm.stringWidth(getText()))/2;
        int y = bounds.y + (bounds.height + fm.getAscent())/2 - 3;

        g2d.drawString(getText(), x, y);
    }

}
