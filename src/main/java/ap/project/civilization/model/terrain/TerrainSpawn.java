package ap.project.civilization.model.terrain;

import ap.project.civilization.model.hex.HexCoord;
import ap.project.civilization.model.hex.HexManager;

import java.util.concurrent.ThreadLocalRandom;

public class TerrainSpawn {
    private final HexManager hexManager;

    public TerrainSpawn(HexManager hexManager) {
        this.hexManager = hexManager;
    }

    public void createTerrain(int number) {
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                TerrainType randomTerrain = TerrainType.values()[ThreadLocalRandom.current().nextInt(TerrainType.values().length)];
                hexManager.putHex(i, j, new Terrain(new HexCoord(i, j), randomTerrain));
            }
        }
    }
}
