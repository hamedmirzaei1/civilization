package ap.project.civilization.controller;

import ap.project.civilization.model.GameModel;
import ap.project.civilization.view.GameFrame;
import ap.project.civilization.view.GamePanel;

public class GameController {
    private GamePanel view;
    private GameModel model;

    private GameLoop gameLoop;
    private CameraController cameraController;

    public GameController() {
        initController();
    }

    public void start() {
        gameLoop.start();
    }

    public void update() {
        model.update();
        cameraController.update();
        view.repaint();
    }

    private void initController() {
        model = new GameModel();

        GameFrame gameFrame = new GameFrame(this);
        view = gameFrame.getView();

        gameLoop = new GameLoop(this);

        cameraController = new CameraController(view.getCamera(), new KeyboardController(view));
        MouseController mouseController = new MouseController(cameraController, view);
    }

    public void exitGame() {
        System.exit(0);
    }

    public GameModel getModel() {
        return model;
    }
}
