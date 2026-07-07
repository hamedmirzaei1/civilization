package ap.project.civilization.view.render.hex;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.unit.base.Unit;
import ap.project.civilization.model.unit.base.UnitManager;
import ap.project.civilization.view.render.Camera;

import java.awt.*;

public class DrawUnit {
    public static void drawUnits(Unit unit, Graphics2D g2d, Camera camera, double hexSize) {
        double screenX = camera.worldToScreenX(unit.getX());
        double screenY = camera.worldToScreenY(unit.getY());
        g2d.setColor(Color.BLUE);
        g2d.fillOval((int)screenX, (int)screenY, (int)hexSize/2, (int)hexSize/2);
    }
}
