package ap.project.civilization.model.hex;

import java.util.Collection;
import java.util.HashMap;

public class HexManager {
    HashMap<HexCoord, Hex> hexData;

    public HexManager() {
        hexData = new HashMap<>();
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
