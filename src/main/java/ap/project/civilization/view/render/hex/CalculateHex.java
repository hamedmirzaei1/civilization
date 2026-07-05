package ap.project.civilization.view.render.hex;

import ap.project.civilization.model.hex.HexCoord;

import java.awt.*;

public class CalculateHex {

    public static Polygon hexShape(double x, double y, double size) {
        Polygon p = new Polygon();
        for (int i = 0; i < 6; i++) {
            double angle = Math.toRadians(60 * i - 30);
            int nx = (int)(x + size * Math.cos(angle));
            int ny = (int)(y + size * Math.sin(angle));

            p.addPoint(nx, ny);
        }
        return p;
    }


    public static double hexToWorldPixelY(int r, double size) {
        return size * 1.5 * r;
    }
    public static double hexToWorldPixelX(int q, int r, double size) {
        return size * Math.sqrt(3) * (q + r / 2.0);
    }

    public static HexCoord worldPixelToHex(double x, double y, double size) {
        double r = y / (size * 1.5);
        double q = x / (size * Math.sqrt(3)) - r / 2.0;

        return new HexCoord((int)q, (int)r);
    }
}
