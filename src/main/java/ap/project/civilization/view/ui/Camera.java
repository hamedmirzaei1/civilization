package ap.project.civilization.view.ui;

import ap.project.civilization.model.hex.HexManager;
import ap.project.civilization.model.util.ModelConstants;
import ap.project.civilization.view.render.MakeHex;
import ap.project.civilization.view.util.ViewConstants;

import java.awt.geom.Point2D;

public class Camera {
    private int screenX;
    private int screenY;


    public Camera() {
        screenX = 0;
        screenY = 0;
    }

    public void move(int dx, int dy) {
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

    public int worldToScreenX(int x) {
        return x - screenX;
    }
    public int worldToScreenY(int y) {
        return y - screenY;
    }

    public int screenToWorldX(int x) {
        return x + screenX;
    }
    public int screenToWorldY(int y) {
        return y + screenY;
    }
}
