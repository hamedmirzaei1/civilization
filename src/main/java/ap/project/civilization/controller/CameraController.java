package ap.project.civilization.controller;

import ap.project.civilization.view.render.Camera;

import java.awt.event.KeyEvent;

public class CameraController {
    private static final int CAMERA_SPEED = 8;

    private final Camera camera;
    private final KeyboardController keyboard;

    public CameraController(Camera camera, KeyboardController keyboard) {
        this.camera = camera;
        this.keyboard = keyboard;
    }

    public void update() {
        double dx = 0, dy = 0;
        if (keyboard.isPressed(KeyEvent.VK_W)) {
            dy = -CAMERA_SPEED;
        }

        if (keyboard.isPressed(KeyEvent.VK_S)) {
            dy = CAMERA_SPEED;
        }

        if (keyboard.isPressed(KeyEvent.VK_A)) {
            dx = -CAMERA_SPEED;
        }
        if (keyboard.isPressed(KeyEvent.VK_D)) {
            dx = CAMERA_SPEED;
        }

        camera.move(dx, dy);

        if (keyboard.isPressed(KeyEvent.VK_EQUALS) || keyboard.isPressed(KeyEvent.VK_ADD)) {
            camera.zoomIn();
        }

        if (keyboard.isPressed(KeyEvent.VK_MINUS) || keyboard.isPressed(KeyEvent.VK_SUBTRACT)) {
            camera.zoomOut();
        }

        camera.updateZoom();
    }

}
