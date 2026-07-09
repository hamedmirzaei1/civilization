package ap.project.civilization.view.render.hex;

import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.hexes.HexType;
import ap.project.civilization.view.util.game.AssetManager;

import java.awt.*;
import java.awt.geom.Path2D;

public class DrawHex {
    private static final Stroke stroke = new BasicStroke(1);
    public static void draw(Graphics2D g2d, Path2D.Double outlineHex, Path2D.Double hexShape, Hex hex, double nx, double ny, int hexSize) {
        g2d.translate(nx, ny);

        g2d.setColor(DrawHexLogic.borderColor(hex));
        g2d.fill(outlineHex);

        g2d.setStroke(stroke);
        g2d.setColor(Color.BLACK);
        g2d.draw(outlineHex);

        if(hex.isVisible()) {
            g2d.setColor(hex.getType().getColor());
            g2d.fill(hexShape);

            drawResource(g2d, hex, hexSize);
        }

        if(hex.getType() ==  HexType.TOWN_HALL) {
            int offset = -(int)(hexSize * 0.75);
            g2d.drawImage(AssetManager.get("TOWN_HALL"), offset, offset, null);
        }


        g2d.translate(-nx, -ny);
    }

    private static void drawResource(Graphics2D g2d, Hex hex, int hexSize) {
        int drawX = 0;
        int drawY = 0;
        String asset = "";

        switch (hex.getType()) {
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
