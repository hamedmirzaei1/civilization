package ap.project.civilization.model;

import ap.project.civilization.model.terrain.HexManager;

public class GameModel {
    HexManager hexManager;

    public GameModel() {
        hexManager = new HexManager();
    }

    public void update() {
    }

    public HexManager getHexManager() {
        return hexManager;
    }
}
