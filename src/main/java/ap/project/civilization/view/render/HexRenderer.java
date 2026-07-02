package ap.project.civilization.view.render;

import ap.project.civilization.model.GameModel;
import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.terrain.Terrain;
import ap.project.civilization.view.ui.Camera;
import ap.project.civilization.view.util.AssetManager;

import java.awt.*;
import java.awt.geom.Point2D;

import static ap.project.civilization.view.render.MakeHex.cameraTransform;
import static ap.project.civilization.view.render.MakeHex.hexToPixel;

public class HexRenderer implements Renderable{
    private final GameModel model;

    public HexRenderer(GameModel model) {
        this.model = model;
    }

    @Override
    public void render(Graphics2D g2d, Camera camera) {
        for(Hex hex : model.getHexManager().getHexes()) { //todo : render only on page hexes
            draw(g2d, camera, hex);
        }
    }

    private void draw(Graphics2D g2d, Camera camera, Hex hex) {
        Point2D.Double pixelCoordinate = hexToPixel(hex.getQ(), hex.getR(), model.getHexManager().getHexSize());
        pixelCoordinate = cameraTransform(pixelCoordinate.x, pixelCoordinate.y, camera);
        Polygon polygon = MakeHex.hexShape(pixelCoordinate.x, pixelCoordinate.y, model.getHexManager().getHexSize());


        if(hex.isVisible()) { // todo : refactor and scale architecture, make renderer lazy
            g2d.setColor(((Terrain)hex).getTerrainType().getColor());
            g2d.fill(polygon);
            g2d.drawImage(AssetManager.get(((Terrain)hex).getTerrainType()), (int)pixelCoordinate.x, (int)pixelCoordinate.y, 40, 40, null);
        }

        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(polygon);
    }

}
