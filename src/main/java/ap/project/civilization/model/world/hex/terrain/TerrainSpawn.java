package ap.project.civilization.model.world.hex.terrain;

import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.core.HexCoord;
import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.hex.core.HexType;
import ap.project.civilization.model.world.unit.movement.FogOfWar;

import java.util.concurrent.ThreadLocalRandom;

public class TerrainSpawn {
    private final HexManager hexManager;

    public TerrainSpawn(HexManager hexManager) {
        this.hexManager = hexManager;
    }
    public void createTerrain(int number) {
        TownHall townHall = TownHall.getInstance();
        hexManager.putHex(townHall.getQ(), townHall.getR(), townHall);
        hexManager.setTownHall(townHall);

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if(i == townHall.getQ() && j == townHall.getR()) continue;

                HexType randomTerrain = HexType.values()[ThreadLocalRandom.current().nextInt(HexType.values().length-1)];
                hexManager.putHex(i, j, new Terrain(new HexCoord(i, j), randomTerrain));
            }
        }
        for(Hex h : FogOfWar.neighbors(townHall, hexManager)) {
            h.setUnlock(true);
        }
    }
}
