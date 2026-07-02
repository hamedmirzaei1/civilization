package ap.project.civilization.view.render;

import ap.project.civilization.model.GameModel;
import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.terrain.TerrainType;
import ap.project.civilization.view.ui.Camera;
import ap.project.civilization.view.util.AssetManager;
import ap.project.civilization.view.util.GameColors;

import java.awt.*;
import java.awt.geom.Point2D;

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
        Polygon polygon = MakeHex.hexShape(pixelCoordinate.x, pixelCoordinate.y, camera, model.getHexManager().getHexSize());


        if(hex.isVisible()) { // todo : refactor and scale architecture, make renderer lazy
            g2d.setColor(GameColors.FOREST_TERRAIN);
            g2d.fill(polygon);
            g2d.drawImage(AssetManager.get(TerrainType.MOUNTAIN), (int)pixelCoordinate.x, (int)pixelCoordinate.y, 40, 40, null);
        }

        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(polygon);
    }

}
