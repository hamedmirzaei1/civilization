package ap.project.civilization.view.render.unit;

import ap.project.civilization.model.unit.base.Unit;
import ap.project.civilization.view.render.Camera;
import ap.project.civilization.view.util.game.GameColors;
import ap.project.civilization.view.util.ui.Fonts;

import java.awt.*;

public class DrawUnit {
    private final static Stroke NORMAL = new BasicStroke(3);
    private final static Stroke SELECTED = new BasicStroke(5);

    public static void drawUnits(Unit unit, Graphics2D g2d, Camera camera, double unitSize) {
        double screenX = camera.worldToScreenX(unit.getMovement().getX());
        double screenY = camera.worldToScreenY(unit.getMovement().getY());
        double r = unitSize/2;


        g2d.setColor(unit.getType().getColor());
        g2d.fillOval((int)(screenX-r), (int)(screenY-r), (int)unitSize, (int)unitSize);

        if(unit.isSelected()) {
            g2d.setColor(GameColors.SELECTED_BORDER);
            g2d.setStroke(SELECTED);
        } else {
            g2d.setColor(Color.WHITE);
            g2d.setStroke(NORMAL);
        }
        g2d.drawOval((int)(screenX-r), (int)(screenY-r), (int)unitSize, (int)unitSize);


        g2d.setColor(Color.WHITE);

        String text = unit.getType().getText();
        g2d.setFont(Fonts.GLOOCK((float) (unitSize * 0.8 / text.length())));
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = (fm.getAscent() - fm.getDescent());
        g2d.drawString(unit.getType().getText(),
                (int)(screenX-textWidth/2),
                (int)(screenY + textHeight/2));
    }
}
