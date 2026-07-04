package ap.project.civilization.controller;

import ap.project.civilization.view.GamePanel;

import java.awt.event.*;

public class MouseController implements MouseListener, MouseMotionListener, MouseWheelListener {
    private final CameraController cameraController;

    public MouseController(CameraController cameraController, GamePanel view) {
        this.cameraController = cameraController;
        view.addMouseListener(this);
        view.addMouseMotionListener(this);
        view.addMouseWheelListener(this);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
