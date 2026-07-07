package ap.project.civilization.view.render.hex;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.terrain.Terrain;
import ap.project.civilization.model.terrain.TownHall;
import ap.project.civilization.view.util.game.AssetManager;
import ap.project.civilization.view.util.game.GameColors;

import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;

public class DrawHex {
    private static final Stroke stroke = new BasicStroke(1);
    public static void draw(Graphics2D g2d, Path2D.Double outlineHex, Path2D.Double hexShape, Hex hex, double nx, double ny, int hexSize) {
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
        if(hex.isMovable()) {
            g2d.setColor(GameColors.MOVABLE_BORDER);
            g2d.fill(outlineHex);
        }
        g2d.setStroke(stroke);
        g2d.setColor(Color.BLACK);
        g2d.draw(outlineHex);

        if((hex instanceof Terrain) && hex.isVisible()) {
            g2d.setColor(((Terrain) hex).getTerrainType().getColor());
            g2d.fill(hexShape);

            drawResource(g2d, hex, hexSize);
        }

        if(hex instanceof TownHall) {
            g2d.setColor(GameColors.TOWN_HALL);
            g2d.fill(hexShape);
            int offset = -(int)(hexSize * 0.75);
            g2d.drawImage(AssetManager.get("TOWN_HALL"), offset, offset, null);
        }


        g2d.translate(-nx, -ny);
    }

    private static void drawResource(Graphics2D g2d, Hex hex, int hexSize) {
        int drawX = 0;
        int drawY = 0;
        String asset = "";

        switch (((Terrain) hex).getTerrainType()) {
            case MOUNTAIN:
                drawX -= hexSize * 0.8;
                drawY -= hexSize * 0.8;
                asset = "ROCK";
                g2d.drawImage(AssetManager.get(asset), drawX, drawY, null);

                drawX = 0;
                drawY = 0;
                asset = "IRON";
                g2d.drawImage(AssetManager.get(asset), drawX, drawY, null);
                break;
            case LAWN:
                asset = "FARM";
                g2d.drawImage(AssetManager.get(asset), drawX, drawY,null);
                break;
            case PLAIN:
                asset = "COW";
                g2d.drawImage(AssetManager.get(asset), drawX, drawY, null);
                break;
            case FOREST:
                drawX -= hexSize /4;
                drawY -= hexSize /4;
                asset = "TREE";
                g2d.drawImage(AssetManager.get(asset), drawX, drawY,null);
        }
    }
}
