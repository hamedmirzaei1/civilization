package ap.project.civilization.view.render;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.terrain.Terrain;
import ap.project.civilization.view.util.AssetManager;
import ap.project.civilization.view.util.GameColors;

import java.awt.*;

public class DrawHex {
    public static void draw(Graphics2D g2d, Polygon polygon, Hex hex, int x, int y, int hexSize) {
        if(hex.isVisible()) {
            g2d.setColor(((Terrain)hex).getTerrainType().getColor());
            g2d.fill(polygon);
            // todo : make the following prescaled
            g2d.drawImage(AssetManager.get(((Terrain)hex).getTerrainType()), (int)x, (int)y, hexSize, hexSize, null);
        }

        if(hex.isUnlock()) {
            g2d.setColor(GameColors.UNLOCK_REGION_BORDER);
            g2d.setStroke(new BasicStroke(4));
        } else {
            g2d.setColor(Color.DARK_GRAY);
        }
        g2d.drawPolygon(polygon);
    }
}
