package ap.project.civilization.view;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame() {
        setWindow();
    }

    private void setWindow() {
        setTitle("Civilization");
        setSize(Constants.getWindowWidth(), Constants.getWindowHeight());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
