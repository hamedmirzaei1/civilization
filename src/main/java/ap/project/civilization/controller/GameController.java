package ap.project.civilization.controller;

import ap.project.civilization.model.GameModel;
import ap.project.civilization.view.GameFrame;
import ap.project.civilization.view.GamePanel;

public class GameController {
    private GamePanel view;
    private GameModel model;

    private GameLoop gameLoop;

    public GameController() {
        initController();
    }

    public void start() {
        gameLoop.start();
    }

    public void update() {
        model.update();
        view.repaint();
    }

    private void initController() {
        model = new GameModel();

        GameFrame gameFrame = new GameFrame(this);
        view = gameFrame.getView();

        gameLoop = new GameLoop(this);
    }

    public void exitGame() {
        System.exit(0);
    }

    public GameModel getModel() {
        return model;
    }
}
