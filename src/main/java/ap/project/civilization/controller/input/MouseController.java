package ap.project.civilization.controller.input;

import ap.project.civilization.controller.ui.SelectionController;
import ap.project.civilization.controller.ui.UIController;
import ap.project.civilization.model.GameModel;
import ap.project.civilization.view.GamePanel;

import java.awt.event.*;

public class MouseController implements MouseListener, MouseMotionListener, MouseWheelListener {
    private final UIController uiController;

    public MouseController(GamePanel view, GameModel model) {
        view.addMouseListener(this);
        view.addMouseMotionListener(this);
        view.addMouseWheelListener(this);

        uiController = new UIController(view, model);
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
        uiController.onMouseClicked(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}
