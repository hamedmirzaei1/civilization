package ap.project.civilization.model.world.hex.core;

import ap.project.civilization.model.util.ModelConstants;
import ap.project.civilization.model.world.building.BuildingFactory;
import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.hex.hexes.HexType;
import ap.project.civilization.model.world.hex.hexes.Terrain;
import ap.project.civilization.model.world.hex.hexes.TownHall;
import ap.project.civilization.model.world.resource.Resource;
import ap.project.civilization.model.world.unit.movement.FogOfWar;

import java.util.concurrent.ThreadLocalRandom;

public class HexFactory {
    private final HexManager hexManager;

    public HexFactory(HexManager hexManager) {
        this.hexManager = hexManager;
    }

    public void createTerrain(HexType type, int q, int r) {
        if(type == HexType.TOWN_HALL) return;

        Terrain terrain = new Terrain(new HexCoord(q, r), type);
        hexManager.putHex(q, r, terrain);

        for(Resource resource : Resource.values()) {
            if(terrain.getType().hasResource(resource)) {
                terrain.getInventory().add(resource, ThreadLocalRandom.current().nextInt(
                        ModelConstants.MIN_TERRAIN_RESOURCE,
                        ModelConstants.MAX_TERRAIN_RESOURCE));
            }

        }
    }

    public void setTownHall() {
        TownHall townHall = TownHall.getInstance();
        hexManager.putHex(townHall.getQ(), townHall.getR(), townHall);
        hexManager.setTownHall(townHall);
        townHall.setBuilding(BuildingFactory.createTownHallBuilding());

        for(Hex h : FogOfWar.neighbors(townHall, hexManager)) {
            h.setUnlock(true);
        }
    }
}
