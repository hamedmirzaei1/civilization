package ap.project.civilization.view.render.hex;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.terrain.Terrain;
import ap.project.civilization.model.terrain.TownHall;
import ap.project.civilization.view.util.game.AssetManager;
import ap.project.civilization.view.util.game.GameColors;

import java.awt.*;
import java.awt.geom.Path2D;

public class DrawHex {
    private static final Stroke BORDER = new BasicStroke(4);
    private static final Stroke NORMAL = new BasicStroke(2);
    private static final Stroke SELECTED = new BasicStroke(6);

    public static void draw(Graphics2D g2d, Path2D.Double outlineHex, Path2D.Double hexShape, Hex hex, double nx, double ny, int hexSize) {
        // todo : make assets prescaled
        g2d.translate(nx, ny);

        if(hex.isUnlock()) {
            g2d.setColor(GameColors.UNLOCK_REGION_BORDER);
            g2d.fill(outlineHex);
        } else {
            g2d.setColor(Color.DARK_GRAY);
            g2d.fill(outlineHex);
        }
        if(hex.isSelected()) {
            g2d.setColor(GameColors.SELECTED_BORDER);
            g2d.fill(outlineHex);
        }

        if((hex instanceof Terrain) && hex.isVisible()) {
            g2d.setColor(((Terrain) hex).getTerrainType().getColor());
            g2d.fill(hexShape);

            drawResource(g2d, hex, 0, 0 , hexSize);
        }

        if(hex instanceof TownHall) {
            g2d.setColor(GameColors.TOWN_HALL);
            g2d.fill(hexShape);
            g2d.drawImage(AssetManager.get("TOWN_HALL"), -(int)(hexSize*0.75), -(int)(hexSize*0.75), (int)(hexSize*1.5), (int)(hexSize*1.5), null);
        }


        g2d.translate(-nx, -ny);
    }

    private static void drawResource(Graphics2D g2d, Hex hex, int x, int y, int hexSize) {
        int drawSize = hexSize;
        int drawX = x;
        int drawY = y;
        String asset = "";

        switch (((Terrain) hex).getTerrainType()) {
            case MOUNTAIN:
                drawX -= hexSize * 0.8;
                drawY -= hexSize * 0.8;
                asset = "ROCK";
                g2d.drawImage(AssetManager.get(asset), drawX, drawY, drawSize, drawSize, null);

                drawSize *= 0.5;
                drawX = x;
                drawY = y;
                asset = "IRON";
                g2d.drawImage(AssetManager.get(asset), drawX, drawY, drawSize, drawSize, null);
                break;
            case LAWN:
                drawSize *= 0.6;
                asset = "FARM";
                g2d.drawImage(AssetManager.get(asset), drawX, drawY, drawSize, drawSize, null);
                break;
            case PLAIN:
                drawSize *= 0.6;
                asset = "COW";
                g2d.drawImage(AssetManager.get(asset), drawX, drawY, drawSize, drawSize, null);
                break;
            case FOREST:
                drawX -= hexSize /4;
                drawY -= hexSize /4;
                asset = "TREE";
                g2d.drawImage(AssetManager.get(asset), drawX, drawY, drawSize, drawSize, null);
        }
    }
}
