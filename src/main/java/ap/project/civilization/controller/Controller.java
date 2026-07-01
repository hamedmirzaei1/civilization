package ap.project.civilization.controller;

import ap.project.civilization.view.GameFrame;
import ap.project.civilization.view.GamePanel;

public class Controller {
    private GamePanel view;

    public Controller() {
        initView();
    }

    private void initView() {
        GameFrame gameFrame = new GameFrame(this);
        view = gameFrame.getView();
    }

    public void exitGame() {
        System.exit(0);
    }
}
