package ap.project.civilization.view.render;

import ap.project.civilization.model.GameModel;
import ap.project.civilization.model.terrain.Hex;
import ap.project.civilization.view.Camera;

import java.awt.*;
import java.awt.geom.Point2D;

public class HexRenderer implements Renderable{
    private GameModel model;

    public HexRenderer(GameModel model) {
        this.model = model;
    }

    public static Point2D.Double hexToPixel(int q, int r, int size) {
        double x = size * Math.sqrt(3) * (q + r / 2.0);
        double y = size * 1.5 * r;

        return new Point2D.Double(x, y);
    }

    private Polygon createHex(double centerX, double centerY, double size) {

        Polygon p = new Polygon();

        for (int i = 0; i < 6; i++) {

            double angle = Math.toRadians(60 * i - 30);

            int x = (int)(centerX + size * Math.cos(angle));
            int y = (int)(centerY + size * Math.sin(angle));

            p.addPoint(x, y);
        }
        return p;
    }

    @Override
    public void render(Graphics2D g2d, Camera camera) {
        for(int i =0; i< 9; i++) {
            for (Hex hex : model.getHexManager().getHexes()[i]) {
                Point2D.Double p = hexToPixel(hex.getQ(), hex.getR(), 20);
                g2d.drawPolygon(createHex(p.x, p.y, 20));
            }
        }
    }
}
