package ap.project.civilization.controller;

import ap.project.civilization.controller.input.KeyboardController;
import ap.project.civilization.controller.input.MouseController;
import ap.project.civilization.model.GameModel;
import ap.project.civilization.view.GameFrame;
import ap.project.civilization.view.GamePanel;

public class GameController {
    private GamePanel view;
    private GameModel model;

    private GameLoop gameLoop;
    private CameraController cameraController;
    private MouseController mouseController;

    public GameController() {
        initController();
    }

    public void start() {
        gameLoop.start();
        view.getMusicPlayer().play();
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
        mouseController = new MouseController(this);
    }

    public void exitGame() {
        System.exit(0);
    }

    public GameModel getModel() {
        return model;
    }

    public GamePanel getView() {
        return view;
    }

    public CameraController getCameraController() {
        return cameraController;
    }

    public MouseController getMouseController() {
        return mouseController;
    }
}
