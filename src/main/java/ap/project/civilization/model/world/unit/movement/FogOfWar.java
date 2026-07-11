package ap.project.civilization.model.world.unit.movement;

import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.unit.core.Unit;

import java.util.ArrayList;
import java.util.Collection;

public class FogOfWar {
    public static Collection<Hex> neighbors(Hex hex, HexManager hexManager) {
        Collection<Hex> result = new ArrayList<>();
        for(int i=-1; i<=1; i++) {
            for(int j=-1; j<=1; j++) {
                if(i==j) continue;

                Hex h = hexManager.getHex(hex.getQ()+i, hex.getR()+j);
                if(h == null) continue;
                result.add(h);
            }
        }
        return result;
    }

    public static Hex getNearHex(Hex hex, Direction direction, HexManager hexManager) {
        return hexManager.getHex(hex.getQ()+direction.getDq(), hex.getR()+direction.getDr());
    }

    public static void makeUnitHexVisible(Unit unit) {
        if(!unit.getCurrentHex().isVisible()) unit.getCurrentHex().setVisible(true);
    }

    public static void makeNeighborsVisible(Hex hex) {
        for(Hex h : neighbors(hex, HexManager.getInstance())) {
            h.setVisible(true);
        }
        hex.setVisible(true);
    }
}
