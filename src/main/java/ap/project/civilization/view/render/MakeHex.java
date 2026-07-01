package ap.project.civilization.view.render;

import ap.project.civilization.model.hex.HexCoord;
import ap.project.civilization.view.Camera;

import java.awt.*;
import java.awt.geom.Point2D;

public class MakeHex {

    public static Polygon hexShape(HexCoord coordinate, Camera camera, double size) {
        Point2D.Double pixelCoordinate = hexToPixel(coordinate.getQ(), coordinate.getR(), (int)size);
        Polygon p = new Polygon();
        for (int i = 0; i < 6; i++) {
            double angle = Math.toRadians(60 * i - 30);
            int x = (int)(pixelCoordinate.x + size * Math.cos(angle));
            int y = (int)(pixelCoordinate.y + size * Math.sin(angle));

            x = camera.worldToScreenX(x);
            y = camera.worldToScreenY(y);
            p.addPoint(x, y);
        }
        return p;
    }

    public static Point2D.Double hexToPixel(int q, int r, int size) {
        double x = size * Math.sqrt(3) * (q + r / 2.0);
        double y = size * 1.5 * r;
        return new Point2D.Double(x, y);
    }
}
