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
        g2d.setColor(Color.BLACK);
        for(HexCoord coordinate : model.getHexManager().getCoordinates()) { //todo : render only on page hexes
            Polygon polygon = CalculateHex.calculate(coordinate, 50); // todo : fix the sizing
            g2d.drawPolygon(polygon);
        }
    }
}
