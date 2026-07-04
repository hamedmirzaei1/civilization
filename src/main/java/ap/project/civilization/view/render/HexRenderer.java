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

import static ap.project.civilization.view.render.MakeHex.*;

public class HexRenderer implements Renderable{
    private final GameModel model;


    public HexRenderer(GameModel model) {
        this.model = model;
    }

    @Override
    public void render(Graphics2D g2d, Camera camera) {
        int size = model.getHexManager().getHexSize();

        HexCoord cameraHexCoord = pixelToHex(camera.getScreenX(), camera.getScreenY(), size);
        int numberQ = (int)(ViewConstants.getWindowWidth()/size);
        int numberR = (int)(ViewConstants.getWindowHeight()/size);

        for(Hex hex : model.getHexManager().getHexes(
                cameraHexCoord.getQ(),
                cameraHexCoord.getR(),
                cameraHexCoord.getQ()+numberQ,
                cameraHexCoord.getR()+numberR
                )) {
            draw(g2d, camera, hex, size);
        }
    }

    private void draw(Graphics2D g2d, Camera camera, Hex hex, int size) {
        Point2D.Double pixelCoordinate = hexToPixel(hex.getQ(), hex.getR(), size); //todo: avoid allocating memory
        pixelCoordinate = cameraTransform(pixelCoordinate.x, pixelCoordinate.y, camera);

//        if(outOfScreen(pixelCoordinate, camera, size)) return;

        Polygon polygon = MakeHex.hexShape(pixelCoordinate.x, pixelCoordinate.y, size);

        if(hex.isVisible()) { // todo : refactor and scale architecture, make renderer lazy
            g2d.setColor(((Terrain)hex).getTerrainType().getColor());
            g2d.fill(polygon);
            g2d.drawImage(AssetManager.get(((Terrain)hex).getTerrainType()), (int)pixelCoordinate.x, (int)pixelCoordinate.y, 35, 35, null);
        }

        g2d.setColor(Color.DARK_GRAY);
        g2d.drawPolygon(polygon);
    }

    private boolean outOfScreen(Point2D.Double point, Camera camera, int margin) {
        if(point.x < -margin || point.x > ViewConstants.getWindowWidth()+margin) {
            return true;
        }
        if(point.y < -margin || point.y > ViewConstants.getWindowHeight()+margin) {
            return true;
        }
        return false;
    }


}
