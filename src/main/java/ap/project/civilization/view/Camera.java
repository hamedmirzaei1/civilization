package ap.project.civilization.view;

import ap.project.civilization.model.hex.HexManager;
import ap.project.civilization.view.render.MakeHex;
import ap.project.civilization.view.util.Constants;

import java.awt.*;
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
        screenX = worldX - Constants.getWindowWidth()/2;
        screenY = worldY - Constants.getWindowHeight()/2;
    }
    public void centerOnWorld(HexManager hexManager) {
        Point2D k = MakeHex.hexToPixel(hexManager.getWorldSize()/2, hexManager.getWorldSize()/2, 50);
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
