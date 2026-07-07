package ap.project.civilization.controller.input;

import ap.project.civilization.controller.GameController;
import ap.project.civilization.view.GamePanel;

import java.awt.event.*;

public class MouseController implements MouseListener, MouseMotionListener, MouseWheelListener {

    private final SelectionController selectionController;

    public MouseController(GamePanel view, SelectionController selectionController) {
        view.addMouseListener(this);
        view.addMouseMotionListener(this);
        view.addMouseWheelListener(this);

        this.selectionController = selectionController;
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

}
