package ap.project.civilization.model;

import ap.project.civilization.model.hex.HexManager;

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
