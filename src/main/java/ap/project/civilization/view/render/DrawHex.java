package ap.project.civilization.view.render;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.terrain.Terrain;
import ap.project.civilization.model.terrain.TownHall;
import ap.project.civilization.view.util.AssetManager;
import ap.project.civilization.view.util.GameColors;

import java.awt.*;

public class DrawHex {

    public static void draw(Graphics2D g2d, Polygon polygon, Hex hex, int x, int y, int hexSize) {
        // todo : make assets prescaled
        if((hex instanceof Terrain) && hex.isVisible()) {
            g2d.setColor(((Terrain) hex).getTerrainType().getColor());
            g2d.fill(polygon);

            drawResource(g2d, hex, x, y , hexSize);
        }

        if(hex instanceof TownHall) {
            g2d.setColor(GameColors.TOWN_HALL);
            g2d.fill(polygon);
            g2d.drawImage(AssetManager.get("townHall"), (int)(x - hexSize*0.75), (int)(y - hexSize*0.75), (int)(hexSize*1.5), (int)(hexSize*1.5), null);
        }

        if(hex.isUnlock()) { // todo : fix borders overlap
            g2d.setColor(GameColors.UNLOCK_REGION_BORDER);
            g2d.setStroke(new BasicStroke(4));
        } else {
            g2d.setColor(Color.DARK_GRAY);
            g2d.setStroke(new BasicStroke(1));
        }


        g2d.drawPolygon(polygon);
    }

    private static void drawResource(Graphics2D g2d, Hex hex, int x, int y, int hexSize) {
        int drawSize = hexSize;
        int drawX = x;
        int drawY = y;

        switch (((Terrain) hex).getTerrainType()) {
            case MOUNTAIN:
                drawSize *= 1;
                drawX -= hexSize * 0.8;
                drawY -= hexSize * 0.8;
                break;
            case LAWN:
                drawSize *= 0.6;
                break;
            case PLAIN:
                drawSize *= 0.6;
                break;
            case FOREST:
                drawX -= hexSize /4;
                drawY -= hexSize /4;
        }
        g2d.drawImage(AssetManager.get(((Terrain)hex).getTerrainType()), drawX, drawY, drawSize, drawSize, null);
    }
}
