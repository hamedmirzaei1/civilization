package ap.project.civilization.view.render;

import ap.project.civilization.model.GameModel;
import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.hex.HexCoord;
import ap.project.civilization.model.terrain.Terrain;
import ap.project.civilization.view.ui.Camera;
import ap.project.civilization.view.util.AssetManager;
import ap.project.civilization.view.util.ViewConstants;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.HashMap;

import static ap.project.civilization.view.render.MakeHex.*;
import static ap.project.civilization.view.util.ViewConstants.HEX_BASE_SIZE;

public class HexRenderer implements Renderable{
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
            draw(g2d, camera, hex, screenHexSize);
        }
    }

    private void draw(Graphics2D g2d, Camera camera, Hex hex, double screenHexSize) {
        double x = camera.worldToScreenX(pixelCoords.get(hex).x);
        double y = camera.worldToScreenY(pixelCoords.get(hex).y);

        Polygon polygon = MakeHex.hexShape(x, y, screenHexSize); //todo : not allocate a polygon for each hex

        if(hex.isVisible()) { // todo : refactor and scale architecture, make renderer lazy
            g2d.setColor(((Terrain)hex).getTerrainType().getColor());
            g2d.fill(polygon);
            // todo : make the following prescaled
            g2d.drawImage(AssetManager.get(((Terrain)hex).getTerrainType()), (int)x, (int)y, (int) screenHexSize /2, (int) screenHexSize /2, null);
        }

        g2d.setColor(Color.DARK_GRAY);
        g2d.drawPolygon(polygon);
    }

}
