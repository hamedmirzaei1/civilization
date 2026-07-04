package ap.project.civilization.view.ui;

import ap.project.civilization.model.hex.HexManager;
import ap.project.civilization.model.util.ModelConstants;
import ap.project.civilization.view.render.MakeHex;
import ap.project.civilization.view.util.ViewConstants;

import java.awt.geom.Point2D;

public class Camera {
    private double screenX;
    private double screenY;

    private double zoom;
    private double targetZoom;

    public Camera() {
        screenX = 0;
        screenY = 0;
        zoom = 1.0;
        targetZoom = 1.0;
    }

    public void move(double dx, double dy) {
        screenX += dx;
        screenY += dy;
    }

    public void centerOn(int worldX, int worldY) {
        screenX = worldX - ViewConstants.getWindowWidth()/2;
        screenY = worldY - ViewConstants.getWindowHeight()/2;
    }
    public void centerOnWorld(HexManager hexManager) {
        Point2D k = MakeHex.hexToPixel(ModelConstants.WORLD_SIZE /2, ModelConstants.WORLD_SIZE /2, hexManager.getHexSize());
        centerOn((int)k.getX(), (int)k.getY());
    }

    public double worldToScreenX(double x) {
        return x - screenX;
    }
    public double worldToScreenY(double y) {
        return y - screenY;
    }

    public double screenToWorldX(int x) {
        return x + screenX;
    }
    public double screenToWorldY(int y) {
        return y + screenY;
    }

    public double getScreenX() {
        return screenX;
    }

    public double getScreenY() {
        return screenY;
    }


    public double getZoom() {
        return zoom;
    }

    public void updateZoom() {
        zoom += (targetZoom - zoom) * 0.1;

    }
    public void zoomIn() {
        targetZoom = Math.min(targetZoom * 1.01, 4.0);
    }
    public void zoomOut() {
        targetZoom = Math.max(targetZoom / 1.01, 0.25);
    }
}
