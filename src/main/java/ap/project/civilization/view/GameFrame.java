package ap.project.civilization.view;

import ap.project.civilization.controller.core.GameController;
import ap.project.civilization.view.navigation.panels.MenuPanel;
import ap.project.civilization.view.navigation.panels.SettingsPanel;
import ap.project.civilization.view.util.ui.ViewConstants;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private JPanel cards;
    private CardLayout cardLayout;

    public GameFrame(GameController controller, GamePanel view) {
        setWindow();
        makeCards(controller, view);
    }

    private void setWindow() {
        setTitle("Civilization");
        setSize(ViewConstants.getWindowWidth(), ViewConstants.getWindowHeight());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void makeCards(GameController controller, GamePanel view) {
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        MenuPanel menuPanel = new MenuPanel(controller, this);
        SettingsPanel settingsPanel = new SettingsPanel();

        cards.add(menuPanel, "MENU");
        cards.add(settingsPanel, "SETTINGS");
        cards.add(view, "GAME");

        cardLayout.show(cards, "MENU");

        add(cards);
        setVisible(true);
    }

    public void changePage(String pageName) {
        cardLayout.show(cards, pageName);
    }

}
