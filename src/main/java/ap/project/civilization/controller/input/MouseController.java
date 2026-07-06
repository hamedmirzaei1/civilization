package ap.project.civilization.controller.input;

import ap.project.civilization.controller.CameraController;
import ap.project.civilization.controller.GameController;
import ap.project.civilization.view.GamePanel;

import java.awt.event.*;

public class MouseController implements MouseListener, MouseMotionListener, MouseWheelListener {
    private final CameraController cameraController;

    private final SelectionController selectionController;

    public MouseController(GameController controller) {
        this.cameraController = controller.getCameraController();
        controller.getView().addMouseListener(this);
        controller.getView().addMouseMotionListener(this);
        controller.getView().addMouseWheelListener(this);

        selectionController = new SelectionController(controller, controller.getCameraController().getCamera());
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
    public void mouseClicked(MouseEvent e) {
        selectionController.select(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}


    public SelectionController getSelectionController() {
        return selectionController;
    }
}
