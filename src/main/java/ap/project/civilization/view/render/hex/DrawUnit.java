package ap.project.civilization.view.render.hex;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.unit.Unit;
import ap.project.civilization.model.unit.UnitManager;

import java.awt.*;

public class DrawUnit {
    public static void drawUnits(double x, double y, Hex hex, Graphics2D g2d, double hexSize, UnitManager unitManager) {
        for(Unit unit : unitManager.getHexUnitData().get(hex)) {
            g2d.setColor(Color.BLUE);
            g2d.fillOval((int)x, (int)y, (int)hexSize/2, (int)hexSize/2);
        }
    }
}
