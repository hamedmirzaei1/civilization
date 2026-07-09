package ap.project.civilization.model.world.hex.terrain;

import ap.project.civilization.model.util.ModelConstants;
import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.hex.core.HexCoord;
import ap.project.civilization.model.world.hex.core.HexType;
import ap.project.civilization.model.world.resource.Resource;

import java.util.concurrent.ThreadLocalRandom;

public class TerrainFactory {
    private HexManager hexManager;

    public TerrainFactory(HexManager hexManager) {
        this.hexManager = hexManager;
    }

    public void createTerrain(HexType type, int q, int r) {
        if(type == HexType.TOWN_HALL) return;

        Terrain terrain = new Terrain(new HexCoord(q, r), type);
        hexManager.putHex(q, r, terrain);

        for(Resource resource : Resource.values()) {
            if(terrain.getType().hasResource(resource)) {
                terrain.getInventory().add(resource,
                        ThreadLocalRandom.current().nextInt(1, ModelConstants.MAXIMUM_TERRAIN_RESOURCE));
            }

        }

    }
}
