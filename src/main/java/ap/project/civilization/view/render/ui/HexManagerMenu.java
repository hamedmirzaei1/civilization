package ap.project.civilization.view.render.ui;

import ap.project.civilization.controller.core.GameController;
import ap.project.civilization.controller.selection.SelectionController;
import ap.project.civilization.view.GamePanel;
import ap.project.civilization.view.navigation.components.MenuButton;
import ap.project.civilization.view.util.ui.UIColors;
import ap.project.civilization.view.util.ui.ViewConstants;

import java.awt.*;
import java.util.HashMap;

import static ap.project.civilization.view.util.ui.ViewConstants.GAME_UI_MARGIN;

public class HexManagerMenu {
    private final static int y = (int)(ViewConstants.getWindowHeight() * 0.5);
    private final static int width = (int)(ViewConstants.getWindowHeight() * 0.4);
    private final static int height = ViewConstants.getWindowHeight()-y-GAME_UI_MARGIN*3;

    private HashMap<String, MenuButton> menuButtons;

    private SelectionController selectionController;
    public HexManagerMenu(GamePanel view) {
        buildButtons(view);
        initButtons();
    }

    public void draw(Graphics2D g2d) {
        if(!selectionController.isSelectionMode()) {
            hideButtons();
            return;
        }
        g2d.setColor(UIColors.MENU_BACKGROUND);
        g2d.fillRoundRect(GAME_UI_MARGIN, y, width, height, 10, 10);

        showButtons();
    }

    private void buildButtons(GamePanel view) {
        menuButtons = new HashMap<>();
        makeButton(view, "close", 16f, 0);
        makeButton(view, "Explore", 24f, 1);
        makeButton(view, "Build", 24f, 2);
        hideButtons();
    }
    private void initButtons() {
        menuButtons.get("close").addActionListener(e -> {
            selectionController.unSelect();
            hideButtons();
        });
    }

    private void makeButton(GamePanel view, String name, float size, int order) {
        int height = 50;
        MenuButton button = new MenuButton(name, size);
        button.setBounds(GAME_UI_MARGIN, y+order*height, width, height);
        view.add(button);
        menuButtons.put(name, button);
    }

    private void hideButtons() {
        for(MenuButton button : menuButtons.values()) {
            button.setVisible(false);
        }
    }
    private void showButtons() {
        for(MenuButton button : menuButtons.values()) {
            if(!button.isVisible()) button.setVisible(true);
        }
    }

    public void setController(GameController controller) {
        selectionController = controller.getSelectionController();
    }
}