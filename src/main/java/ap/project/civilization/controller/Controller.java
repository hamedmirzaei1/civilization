package ap.project.civilization.controller;

import ap.project.civilization.view.GameFrame;
import ap.project.civilization.view.GamePanel;

public class Controller {
    private GamePanel view;

    public Controller() {
        initGameWindow();
    }

    private void initGameWindow() {
        GameFrame gameFrame = new GameFrame();
        view = gameFrame.getView();
    }
}
