package ap.project.civilization.controller;

import javax.swing.*;

public class GameLoop {
    private Timer loop;

    private final int TARGET_FPS = 60;
    private final int DELAY = 1000 / TARGET_FPS;

    public GameLoop(GameController controller) {
        loop = new Timer(DELAY, e -> controller.update());
    }

    public void start() {
        loop.start();
    }
    public void stop() {
        loop.stop();
    }
}
