package ap.project.civilization.model.world.hex.core;

import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.hex.hexes.HexType;
import ap.project.civilization.model.world.hex.hexes.TownHall;

import java.util.concurrent.ThreadLocalRandom;

public class TerrainSpawn {
    private final HexFactory hexFactory;

    public TerrainSpawn(HexManager hexManager) {
        hexFactory = new HexFactory(hexManager);
    }

    public void createTerrain(int number) {
        TownHall townHall = TownHall.getInstance();

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if(i == townHall.getQ() && j == townHall.getR()) continue;

                HexType randomTerrain = HexType.values()[ThreadLocalRandom.current().nextInt(HexType.values().length-1)];

                hexFactory.createTerrain(randomTerrain, i, j);
            }
        }

        hexFactory.setTownHall();
    }
}
