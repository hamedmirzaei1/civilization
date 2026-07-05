package ap.project.civilization.view.render;

import ap.project.civilization.model.util.ModelConstants;
import ap.project.civilization.view.render.hex.CalculateHex;
import ap.project.civilization.view.util.ViewConstants;


public class Camera {
    private double cameraX;
    private double cameraY;

    private double zoom;
    private double targetZoom;

    public Camera() {
        cameraX = 0;
        cameraY = 0;
        zoom = 1.0;
        targetZoom = 1.0;
    }

    public void move(double dx, double dy) {
        cameraX += dx;
        cameraY += dy;
    }

    public void centerOn(double worldX, double worldY) {
        cameraX = worldX - ViewConstants.getWindowWidth()/(2*zoom);
        cameraY = worldY - ViewConstants.getWindowHeight()/(2*zoom);
    }
    public void centerOnWorld() {
        centerOn(
                CalculateHex.hexToWorldPixelX(ModelConstants.WORLD_SIZE /2, ModelConstants.WORLD_SIZE /2, ViewConstants.HEX_BASE_SIZE),
                CalculateHex.hexToWorldPixelY(ModelConstants.WORLD_SIZE/2, ViewConstants.HEX_BASE_SIZE)
        );
    }

    public double worldToScreenX(double x) {
        return (x - cameraX) * zoom;
    }
    public double worldToScreenY(double y) {
        return (y - cameraY) * zoom;
    }

    public double screenToWorldX(int x) {
        return (x / zoom) + cameraX;
    }
    public double screenToWorldY(int y) {
        return (y / zoom) + cameraY;
    }


    public void updateZoom() {
        double diff = targetZoom - zoom;

        if (Math.abs(diff) < 0.0005) {
            zoom = targetZoom;
            return;
        }

        double centerWorldX = screenToWorldX(ViewConstants.getWindowWidth() / 2);
        double centerWorldY = screenToWorldY(ViewConstants.getWindowHeight() / 2);

        zoom += diff * 0.5;

        centerOn(centerWorldX, centerWorldY);
    }

    public void zoomIn() {
        targetZoom = Math.min(targetZoom * 1.03, 3);
    }
    public void zoomOut() {
        targetZoom = Math.max(targetZoom / 1.03, 0.8);
    }
    public double getZoom() {
        return zoom;
    }

    public double getCameraX() {
        return cameraX;
    }

    public double getCameraY() {
        return cameraY;
    }
}
