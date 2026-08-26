package ap.project.civilization.model.world.hex.core;

import ap.project.civilization.model.world.building.BuildingFactory;
import ap.project.civilization.model.world.building.BuildingType;
import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.hex.hexes.HexType;
import ap.project.civilization.model.world.hex.hexes.Terrain;
import ap.project.civilization.model.world.hex.hexes.TownHall;
import ap.project.civilization.model.world.unit.movement.Direction;
import ap.project.civilization.model.world.unit.movement.FogOfWar;

import java.util.concurrent.ThreadLocalRandom;

public class TerrainSpawn {
    private final HexFactory hexFactory;
    private final HexManager hexManager;

    private final int extendRate = 0;

    public TerrainSpawn(HexManager hexManager) {
        this.hexManager = hexManager;
        hexFactory = new HexFactory(hexManager);
    }

    public void createTerrain(int number) {
        TownHall townHall = TownHall.getInstance();

        int counter = 0;
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if(i == townHall.getQ() && j == townHall.getR()) continue;

                HexType randomTerrain = HexType.values()[ThreadLocalRandom.current().nextInt(HexType.values().length - 1)];
                hexFactory.createTerrain(randomTerrain, i, j);
            }
        }

        hexFactory.setTownHall();
    }

    private boolean isExtendable(HexType hexType) {
        if(hexType == HexType.SEA && extendRate < ThreadLocalRandom.current().nextInt(10, 30)) {
            return true;
        }
        if(hexType == HexType.ROCK_MOUNTAIN && extendRate < ThreadLocalRandom.current().nextInt(5, 15)) {
            return true;
        }
        return false;
    }
}
