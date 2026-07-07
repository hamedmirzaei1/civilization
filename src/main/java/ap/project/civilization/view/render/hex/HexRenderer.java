package ap.project.civilization.view.render.hex;

import ap.project.civilization.model.GameModel;
import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.hex.HexCoord;
import ap.project.civilization.view.render.Camera;
import ap.project.civilization.view.render.Renderable;
import ap.project.civilization.view.util.ui.ViewConstants;

import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.HashMap;

import static ap.project.civilization.view.render.hex.CalculateHex.*;
import static ap.project.civilization.view.util.ui.ViewConstants.HEX_BASE_SIZE;

public class HexRenderer implements Renderable {
    private final GameModel model;
    private final HashMap<Hex, Point2D.Double> pixelCoords;

    private Path2D.Double outlineHex;
    private Path2D.Double hexShape;
    private double screenHexSize;
    public HexRenderer(GameModel model) {
        this.model = model;


        pixelCoords = new HashMap<>();
        for(Hex hex : model.getHexManager().getHexes()) {
            pixelCoords.put(hex, new Point2D.Double(
                    hexToWorldPixelX(hex.getQ(), hex.getR(), HEX_BASE_SIZE),
                    hexToWorldPixelY(hex.getR(), HEX_BASE_SIZE)
            ));
        }

        outlineHex = CalculateHex.hexShape(HEX_BASE_SIZE, 1);
        hexShape = CalculateHex.hexShape(HEX_BASE_SIZE, 0.95);
        screenHexSize = HEX_BASE_SIZE;
    }

    @Override
    public void render(Graphics2D g2d, Camera camera) {
        HexCoord cameraHexCoord = worldPixelToHex(camera.getCameraX(), camera.getCameraY(), HEX_BASE_SIZE);
        int numberQ = (int)(ViewConstants.getWindowWidth()/ screenHexSize);
        int numberR = (int)(ViewConstants.getWindowHeight()/ screenHexSize);

        for(Hex hex : model.getHexManager().getHexes(
                cameraHexCoord.getQ()-numberQ/2,
                cameraHexCoord.getR()-numberR/4,
                cameraHexCoord.getQ()+numberQ,
                cameraHexCoord.getR()+numberR
                )) {
            double x = camera.worldToScreenX(pixelCoords.get(hex).x);
            double y = camera.worldToScreenY(pixelCoords.get(hex).y);

            DrawHex.draw(g2d, outlineHex, hexShape, hex, x, y, (int)screenHexSize);
            DrawUnit.drawUnits(x, y , hex, g2d, screenHexSize, model.getUnitManager());
        }
    }

    public void updateShape(Camera camera) {
        screenHexSize = HEX_BASE_SIZE * camera.getZoom();
        outlineHex = CalculateHex.hexShape(screenHexSize, 1);
        hexShape = CalculateHex.hexShape(screenHexSize, 0.95);
    }

    public double getScreenHexSize() {
        return screenHexSize;
    }
}
