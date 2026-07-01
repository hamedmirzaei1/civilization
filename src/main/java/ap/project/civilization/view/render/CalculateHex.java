package ap.project.civilization.view.render;

import ap.project.civilization.model.hex.HexCoord;
import ap.project.civilization.model.terrain.Forest;
import ap.project.civilization.model.terrain.Terrain;
import ap.project.civilization.view.util.GameColors;

import java.awt.*;
import java.awt.geom.Point2D;

public class CalculateHex {

    public static Polygon calculate(HexCoord coordinate, double size) {
        Point2D.Double pixelCoordinate = hexToPixel(coordinate.getQ(), coordinate.getR(), (int)size);

        Polygon p = new Polygon();
        for (int i = 0; i < 6; i++) {
            double angle = Math.toRadians(60 * i - 30);
            int x = (int)(pixelCoordinate.x + size * Math.cos(angle));
            int y = (int)(pixelCoordinate.y + size * Math.sin(angle));

            p.addPoint(x, y);
        }
        return p;
    }

    private static Point2D.Double hexToPixel(int q, int r, int size) {
        double x = size * Math.sqrt(3) * (q + r / 2.0);
        double y = size * 1.5 * r;
        return new Point2D.Double(x, y);
    }

    private static Color getColor(Terrain terrain) {
//        if(terrain instanceof Forest) {
//            return GameColors.FOREST_TERRAIN;
//        }
        return GameColors.FOREST_TERRAIN;
    }
}
