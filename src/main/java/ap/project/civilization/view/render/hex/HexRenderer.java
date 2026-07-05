package ap.project.civilization.view.render.hex;

import ap.project.civilization.model.GameModel;
import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.hex.HexCoord;
import ap.project.civilization.view.render.Camera;
import ap.project.civilization.view.render.Renderable;
import ap.project.civilization.view.util.ViewConstants;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.HashMap;

import static ap.project.civilization.view.render.hex.CalculateHex.*;
import static ap.project.civilization.view.util.ViewConstants.HEX_BASE_SIZE;

public class HexRenderer implements Renderable {
    private final GameModel model;
    private final HashMap<Hex, Point2D.Double> pixelCoords;

    public HexRenderer(GameModel model) {
        this.model = model;


        pixelCoords = new HashMap<>();
        for(Hex hex : model.getHexManager().getHexes()) {
            pixelCoords.put(hex, new Point2D.Double(
                    hexToWorldPixelX(hex.getQ(), hex.getR(), HEX_BASE_SIZE),
                    hexToWorldPixelY(hex.getR(), HEX_BASE_SIZE)
            ));
        }
    }

    @Override
    public void render(Graphics2D g2d, Camera camera) {
        double screenHexSize = HEX_BASE_SIZE * camera.getZoom();

        HexCoord cameraHexCoord = worldPixelToHex(camera.getCameraX(), camera.getCameraY(), HEX_BASE_SIZE);
        int numberQ = (int)(ViewConstants.getWindowWidth()/ screenHexSize);
        int numberR = (int)(ViewConstants.getWindowHeight()/ screenHexSize);

        for(Hex hex : model.getHexManager().getHexes(
                cameraHexCoord.getQ()-numberQ,
                cameraHexCoord.getR(),
                cameraHexCoord.getQ()+numberQ,
                cameraHexCoord.getR()+numberR
                )) {
            placeHex(g2d, camera, hex, screenHexSize);
        }
    }

    private void placeHex(Graphics2D g2d, Camera camera, Hex hex, double screenHexSize) {
        double x = camera.worldToScreenX(pixelCoords.get(hex).x);
        double y = camera.worldToScreenY(pixelCoords.get(hex).y);

        Polygon polygon = CalculateHex.hexShape(x, y, screenHexSize); //todo : not allocate a polygon for each hex

        DrawHex.draw(g2d, polygon, hex, (int)x, (int)y, (int)screenHexSize);
    }

}
