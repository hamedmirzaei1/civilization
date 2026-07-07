package ap.project.civilization.model.unit.movement;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.hex.HexManager;

import java.util.ArrayList;
import java.util.Collection;

public class FogOfWar {
    public static Collection<Hex> neigbors(Hex hex, HexManager hexManager) {
        Collection<Hex> result = new ArrayList<>();
        for(int i=-1; i<=1; i++) {
            for(int j=-1; j<=1; j++) {
                if(i==j) continue;
                result.add(hexManager.getHex(hex.getQ()+i, hex.getR()+j));
            }
        }
        return result;
    }
}
