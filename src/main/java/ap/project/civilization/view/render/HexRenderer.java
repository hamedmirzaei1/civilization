package ap.project.civilization.view.render;

import ap.project.civilization.model.GameModel;
import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.terrain.Terrain;
import ap.project.civilization.view.Camera;
import ap.project.civilization.view.util.GameColors;

import java.awt.*;

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
        Polygon polygon = MakeHex.hexShape(hex.getCoordinate(), camera, 50); // todo : fix the sizing

        if(hex instanceof Terrain && ((Terrain)hex).isVisible()) { // todo : better architecture
            g2d.setColor(GameColors.FOREST_TERRAIN); // todo: color according to terrain
            g2d.fill(polygon);
        }

        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(polygon);
    }

}
