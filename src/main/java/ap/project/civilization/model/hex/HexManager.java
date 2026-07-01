package ap.project.civilization.model.hex;

import ap.project.civilization.model.terrain.TerrainSpawn;

import java.util.Collection;
import java.util.HashMap;

public class HexManager {
    private HashMap<HexCoord, Hex> hexData;

    private final TerrainSpawn terrainSpawn;
    private int worldSize;

    public HexManager() {
        hexData = new HashMap<>();
        terrainSpawn = new TerrainSpawn(this);
        worldSize = 30;
        terrainSpawn.createTerrain(worldSize);
    }


    public Hex getHex(int q, int r) {
        return hexData.get(new HexCoord(q, r));
    }
    public Hex getHex(HexCoord coordinate) {
        return hexData.get(coordinate);
    }
    public void putHex(int q, int r, Hex hex) {
        hexData.put(new HexCoord(q, r), hex);
    }

    public Collection<HexCoord> getCoordinates() {
        return hexData.keySet();
    }
    public Collection<Hex> getHexes() {
        return hexData.values();
    }

    public int getWorldSize() {
        return worldSize;
    }
}
