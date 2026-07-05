package ap.project.civilization;

import ap.project.civilization.controller.GameController;

import javax.swing.*;

public class Main {
    static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameController controller = new GameController();
        });
    }
}
