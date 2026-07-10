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

    public TerrainSpawn(HexManager hexManager) {
        this.hexManager = hexManager;
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
        Terrain terrain = (Terrain) FogOfWar.getNearHex(townHall, Direction.UP_RIGHT, hexManager);
        BuildingFactory.createProductionBuilding(terrain, BuildingType.FIELD);
    }
}
