package ap.project.civilization;

import ap.project.civilization.controller.GameController;
import ap.project.civilization.model.GameModel;
import ap.project.civilization.view.GameFrame;
import ap.project.civilization.view.GamePanel;

import javax.swing.*;

public class Main {
    static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameModel model = new GameModel();
            GamePanel view = new GamePanel(model);
            GameController controller = new GameController(model, view);

            view.setController(controller);

            GameFrame gameFrame = new GameFrame(controller, view);
        });
    }
}
