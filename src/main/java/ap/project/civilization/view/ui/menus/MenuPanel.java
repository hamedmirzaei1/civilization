package ap.project.civilization.view.ui.menus;

import ap.project.civilization.controller.GameController;
import ap.project.civilization.view.GameFrame;
import ap.project.civilization.view.util.UIColors;

import javax.swing.*;

public class MenuPanel extends JPanel {
    JButton startGameButton;
    JButton settingsButton;
    JButton exitButton;

    public MenuPanel(GameController controller, GameFrame gameFrame) {
        setPanel();
        createButtons(controller, gameFrame);
    }

    private void setPanel() {
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxLayout);

        setBackground(UIColors.MENU_BACKGROUND);
    }
    private void createButtons(GameController controller, GameFrame gameFrame) {
        startGameButton = new MenuButton("Start");
        settingsButton = new MenuButton("Settings");
        exitButton = new MenuButton("Exit");

        initButtons(controller, gameFrame);

        placeButtons();
    }
    private void placeButtons() {
        add(Box.createVerticalGlue());
        add(startGameButton);
        add(settingsButton);
        add(exitButton);
        add(Box.createVerticalGlue());

    }

    private void initButtons(GameController controller, GameFrame gameFrame) {
        startGameButton.addActionListener(e -> gameFrame.changePage("GAME"));
        settingsButton.addActionListener(e -> gameFrame.changePage("SETTINGS"));
        exitButton.addActionListener(e -> {
            controller.exitGame();
        });
    }
}
