package ap.project.civilization.view.render;

import ap.project.civilization.model.hex.HexCoord;
import ap.project.civilization.view.ui.Camera;

import java.awt.*;
import java.awt.geom.Point2D;

public class MakeHex {

    public static Polygon hexShape(double x, double y, Camera camera, double size) {
        Polygon p = new Polygon();
        for (int i = 0; i < 6; i++) {
            double angle = Math.toRadians(60 * i - 30);
            int nx = (int)(x + size * Math.cos(angle));
            int ny = (int)(y + size * Math.sin(angle));

            nx = camera.worldToScreenX(nx);
            ny = camera.worldToScreenY(ny);
            p.addPoint(nx, ny);
        }
        return p;
    }

    public static Point2D.Double hexToPixel(int q, int r, int size) {
        double x = size * Math.sqrt(3) * (q + r / 2.0);
        double y = size * 1.5 * r;
        return new Point2D.Double(x, y);
    }
}
