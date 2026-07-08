package ap.project.civilization.model.terrain;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.hex.HexCoord;
import ap.project.civilization.model.hex.HexManager;
import ap.project.civilization.model.unit.movement.FogOfWar;

import java.util.concurrent.ThreadLocalRandom;

public class TerrainSpawn {
    private final HexManager hexManager;

    public TerrainSpawn(HexManager hexManager) {
        this.hexManager = hexManager;
    }
    public void createTerrain(int number) {
        TownHall townHall = new TownHall();
        hexManager.putHex(townHall.getQ(), townHall.getR(), townHall);
        hexManager.setTownHall(townHall);

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if(i == townHall.getQ() && j == townHall.getR()) continue;

                TerrainType randomTerrain = TerrainType.values()[ThreadLocalRandom.current().nextInt(TerrainType.values().length)];
                hexManager.putHex(i, j, new Terrain(new HexCoord(i, j), randomTerrain));
            }
        }
        for(Hex h : FogOfWar.neighbors(townHall, hexManager)) {
            h.setUnlock(true);
        }
    }
}
