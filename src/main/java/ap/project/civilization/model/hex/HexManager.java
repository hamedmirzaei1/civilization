package ap.project.civilization.model.hex;

import ap.project.civilization.model.terrain.TerrainSpawn;

import java.util.Collection;
import java.util.HashMap;

public class HexManager {
    private HashMap<HexCoord, Hex> hexData;

    private TerrainSpawn terrainSpawn;

    public HexManager() {
        hexData = new HashMap<>();
        terrainSpawn = new TerrainSpawn(this);

        terrainSpawn.createTerrain(30);
    }


    public Hex getHex(int q, int r) {
        return hexData.get(new HexCoord(q, r));
    }
    public void putHex(int q, int r, Hex hex) {
        hexData.put(new HexCoord(q, r), hex);
    }

    public Collection<HexCoord> getCoordinates() {
        return hexData.keySet();
    }
}
