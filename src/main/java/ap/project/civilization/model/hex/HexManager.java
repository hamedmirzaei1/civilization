package ap.project.civilization.model.hex;

import ap.project.civilization.model.terrain.TerrainSpawn;
import ap.project.civilization.model.util.ModelConstants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class HexManager {
    private HashMap<HexCoord, Hex> hexData;

    private TerrainSpawn terrainSpawn;

    public HexManager() {
        hexData = new HashMap<>();
        terrainSpawn = new TerrainSpawn(this);
        terrainSpawn.createTerrain(ModelConstants.WORLD_SIZE);
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
    public Collection<Hex> getHexes(int startQ, int startR, int endQ, int endR) {
        Collection<Hex> result = new ArrayList<>();
        for(int i=startQ; i<=endQ; i++) {
            for(int j=startR; j<=endR; j++) {
                if(!hexData.containsKey(new HexCoord(i, j))) continue;
                result.add(getHex(i, j));
            }
        }
        return result;
    }

}
