package ap.project.civilization.view.render.unit;

import ap.project.civilization.model.unit.base.Unit;
import ap.project.civilization.view.render.Camera;
import ap.project.civilization.view.util.game.GameColors;
import ap.project.civilization.view.util.ui.Fonts;

import java.awt.*;

public class DrawUnit {
    private final static Stroke NORMAL = new BasicStroke(6);
    private final static Stroke SELECTED = new BasicStroke(8);
    public static void drawUnits(Unit unit, Graphics2D g2d, Camera camera, double unitSize) {
        double screenX = camera.worldToScreenX(unit.getX());
        double screenY = camera.worldToScreenY(unit.getY());

        if(unit.isSelected()) {
            g2d.setColor(GameColors.SELECTED_BORDER);
            g2d.setStroke(SELECTED);
        } else {
            g2d.setColor(Color.WHITE);
            g2d.setStroke(NORMAL);
        }


        double r = unitSize/2;
        g2d.drawOval((int)(screenX-r), (int)(screenY-r), (int)unitSize, (int)unitSize);

        g2d.setColor(GameColors.EXPLORER_UNIT);
        g2d.fillOval((int)(screenX-r), (int)(screenY-r), (int)unitSize, (int)unitSize);


        g2d.setColor(Color.WHITE);
        g2d.setFont(Fonts.GLOOCK((float) (unitSize * 0.8)));
        g2d.drawString("E", (int)(screenX-r/2), (int)(screenY+r*0.6));
    }
}
