package ap.project.civilization.controller;

import ap.project.civilization.controller.input.KeyboardController;
import ap.project.civilization.controller.input.MouseController;
import ap.project.civilization.controller.input.SelectionController;
import ap.project.civilization.model.GameModel;
import ap.project.civilization.view.GamePanel;

public class GameController {
    private final GamePanel view;
    private final GameModel model;

    private GameLoop gameLoop;

    private KeyboardController keyboardController;
    private MouseController mouseController;
    private SelectionController selectionController;

    private CameraController cameraController;

    public GameController(GameModel model, GamePanel view) {
        this.model = model;
        this.view = view;

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
        selectionController = new SelectionController(model, view.getCamera());
        mouseController = new MouseController(view, selectionController);
        keyboardController = new KeyboardController(view);
        cameraController = new CameraController(view.getCamera(),keyboardController);

        gameLoop = new GameLoop(this);
    }

    public void exitGame() {
        System.exit(0);
    }

    public SelectionController getSelectionController() {
        return selectionController;
    }
}
