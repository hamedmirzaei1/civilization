package ap.project.civilization.view.render.ui;

import ap.project.civilization.view.GamePanel;
import ap.project.civilization.view.ui.menus.MenuButton;
import ap.project.civilization.view.util.UIColors;
import ap.project.civilization.view.util.ViewConstants;

import javax.swing.*;
import java.awt.*;

public class HexManagerMenu {
    private final static int margin = 15;
    private final static int y = (int)(ViewConstants.getWindowHeight() * 0.5);
    private final static int width = (int)(ViewConstants.getWindowHeight() * 0.4);
    private final static int height = ViewConstants.getWindowHeight()-y-margin*3;

    private boolean showing;

    private MenuButton exitButton;
    private MenuButton buildButton;

    public HexManagerMenu(GamePanel view) {
        showing = true;

        buildButtons(view);
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(UIColors.MENU_BACKGROUND);
        g2d.fillRoundRect(margin, y, width, height, 10, 10);

        if(!exitButton.isVisible()) exitButton.setVisible(true);
    }

    private void buildButtons(GamePanel view) {
        makeExitButton(view);
        makeBuildButton(view);
    }
    private void makeExitButton(GamePanel view) {
        exitButton = new MenuButton("close",  16f);
        exitButton.setBounds(margin, y , width, 40);
        view.add(exitButton);
        exitButton.addActionListener(e -> {
            showing = false;
            hideButtons();
        });
    }
    private void makeBuildButton(GamePanel view) {
        buildButton = new MenuButton("Build", 24f);
        buildButton.setBounds(margin, y+40, width, 40);
        view.add(buildButton);
    }

    private void hideButtons() {
        exitButton.setVisible(false);
        buildButton.setVisible(false);
    }

    public boolean isShowing() {
        return showing;
    }
}