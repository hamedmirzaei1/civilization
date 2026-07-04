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

    public void centerOn(double worldX, double worldY) {
        screenX = worldX - ViewConstants.getWindowWidth()/2;
        screenY = worldY - ViewConstants.getWindowHeight()/2;
    }
    public void centerOnWorld() {
        centerOn(
                MakeHex.hexToPixelX(ModelConstants.WORLD_SIZE /2, ModelConstants.WORLD_SIZE /2, ViewConstants.HEX_BASE_SIZE),
                MakeHex.hexToPixelY(ModelConstants.WORLD_SIZE/2, ViewConstants.HEX_BASE_SIZE)
        );
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
        double diff = targetZoom - zoom;

        if (Math.abs(diff) > 0.0005) {
            zoom += diff * 0.3;
        } else {
            zoom = targetZoom;
        }
    }
    public void zoomIn() {
        targetZoom = Math.min(targetZoom * 1.01, 2);
    }
    public void zoomOut() {
        targetZoom = Math.max(targetZoom / 1.01, 0.8);
    }
}
