package ap.project.civilization.view;

import ap.project.civilization.view.menu.MenuPanel;
import ap.project.civilization.view.menu.SettingsPanel;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private JPanel cards;
    private CardLayout cardLayout;
    private GamePanel gamePanel;

    public GameFrame() {
        setWindow();
        gamePanel = new GamePanel();
        makeCards();
    }

    private void setWindow() {
        setTitle("Civilization");
        setSize(Constants.getWindowWidth(), Constants.getWindowHeight());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void makeCards() {
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        MenuPanel menuPanel = new MenuPanel();
        SettingsPanel settingsPanel = new SettingsPanel();

        cards.add(menuPanel, "MENU");
        cards.add(settingsPanel, "SETTINGS");
        cards.add(gamePanel, "GAME");

        cardLayout.show(cards, "MENU");

        add(cards);
        setVisible(true);
    }

    public void changePage(String pageName) {
        cardLayout.show(cards, pageName);
    }

    public GamePanel getView() {
        return gamePanel;
    }
}
