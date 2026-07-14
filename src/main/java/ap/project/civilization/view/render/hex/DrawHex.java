package ap.project.civilization.view.render.hex;

import ap.project.civilization.model.world.building.Building;
import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.hexes.HexType;
import ap.project.civilization.model.world.hex.hexes.Terrain;
import ap.project.civilization.model.world.resource.Inventory;
import ap.project.civilization.model.world.resource.Resource;
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

            if(hex.hasBuilding()) {
                int offset = -(int)(hexSize * 0.75);
                g2d.drawImage(hex.getBuilding().getType().getAsset(), offset, offset, null);
            }
            if(hex.getType() != HexType.TOWN_HALL) drawResource(g2d, hex, hexSize);
        }


        g2d.translate(-nx, -ny);
    }

    private static void drawResource(Graphics2D g2d, Hex hex, int hexSize) {
        int drawX = 0;
        int drawY = 0;

        if(hex.getType() == HexType.MOUNTAIN) drawX -= hexSize * 0.6;
        if(hex.getType() == HexType.FOREST) {
            drawX -= hexSize /4;
            drawY -= hexSize /4;
        }

        Terrain terrain = ((Terrain)hex);

        for(Resource resource : hex.getType().getResources()) {
            if(resource == Resource.IRON) { drawX += (int)(hexSize * 0.7); }

            if (terrain.getInventory().contains(resource)) {
                g2d.drawImage(resource.getAsset(hex), drawX, drawY, null);
            }

            if(resource == Resource.IRON) { drawX -= (int)(hexSize * 0.6); }
        }
    }
}
