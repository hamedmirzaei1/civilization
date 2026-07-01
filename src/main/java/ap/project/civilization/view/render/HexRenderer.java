package ap.project.civilization.view.render;

import ap.project.civilization.model.GameModel;
import ap.project.civilization.model.hex.HexCoord;
import ap.project.civilization.view.Camera;

import java.awt.*;

public class HexRenderer implements Renderable{
    private final GameModel model;

    public HexRenderer(GameModel model) {
        this.model = model;
    }

    @Override
    public void render(Graphics2D g2d, Camera camera) {
        for(HexCoord coordinate : model.getHexManager().getCoordinates()) {
            Polygon polygon = CalculateHex.calculate(coordinate, 20); // todo : fix the sizing
            g2d.drawPolygon(polygon);
        }
    }
}
