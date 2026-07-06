package ap.project.civilization.view.render.ui;

import ap.project.civilization.controller.GameController;
import ap.project.civilization.view.GamePanel;
import ap.project.civilization.view.ui.menus.MenuButton;
import ap.project.civilization.view.util.UIColors;
import ap.project.civilization.view.util.ViewConstants;

import java.awt.*;

import static ap.project.civilization.view.util.ViewConstants.GAME_UI_MARGIN;

public class HexManagerMenu {
    private final static int y = (int)(ViewConstants.getWindowHeight() * 0.5);
    private final static int width = (int)(ViewConstants.getWindowHeight() * 0.4);
    private final static int height = ViewConstants.getWindowHeight()-y-GAME_UI_MARGIN*3;


    private MenuButton exitButton;
    private MenuButton buildButton;

    private GameController controller;
    public HexManagerMenu(GamePanel view, GameController controller) {
        this.controller = controller;
        buildButtons(view);
    }

    public void draw(Graphics2D g2d) {
        if(!isSelectionMode()) {
            hideButtons();
            return;
        }
        g2d.setColor(UIColors.MENU_BACKGROUND);
        g2d.fillRoundRect(GAME_UI_MARGIN, y, width, height, 10, 10);

        showButtons();
    }

    private void buildButtons(GamePanel view) {
        makeExitButton(view);
        makeBuildButton(view);
        hideButtons();
    }
    private void makeExitButton(GamePanel view) {
        exitButton = new MenuButton("close",  16f);
        exitButton.setBounds(GAME_UI_MARGIN, y , width, 40);
        view.add(exitButton);
        exitButton.addActionListener(e -> {
            setSelectionMode(false);
            hideButtons();
        });
    }
    private void makeBuildButton(GamePanel view) {
        buildButton = new MenuButton("Build", 24f);
        buildButton.setBounds(GAME_UI_MARGIN, y+40, width, 40);
        view.add(buildButton);
    }

    private void hideButtons() {
        exitButton.setVisible(false);
        buildButton.setVisible(false);
    }
    private void showButtons() {
        if(!exitButton.isVisible()) exitButton.setVisible(true);
        if(!buildButton.isVisible()) buildButton.setVisible(true);
    }
    private boolean isSelectionMode() {
        return controller.getMouseController().getSelectionController().isSelectionMode();
    }
    private void setSelectionMode(boolean hexSelected) {
        controller.getMouseController().getSelectionController().setSelectionMode(hexSelected);
    }
}