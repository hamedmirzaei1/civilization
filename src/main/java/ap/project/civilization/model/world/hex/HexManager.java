package ap.project.civilization.model.world.hex;

import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.core.HexCoord;
import ap.project.civilization.model.world.hex.core.TerrainSpawn;
import ap.project.civilization.model.util.ModelConstants;
import ap.project.civilization.model.world.hex.hexes.MarginHex;
import ap.project.civilization.model.world.unit.movement.Direction;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import static ap.project.civilization.view.render.hex.CalculateHex.hexToWorldPixelX;
import static ap.project.civilization.view.render.hex.CalculateHex.hexToWorldPixelY;
import static ap.project.civilization.view.util.ui.ViewConstants.HEX_BASE_SIZE;

public class HexManager {
    private static HexManager instance;

    private HashMap<HexCoord, Hex> hexData;

    private final TerrainSpawn terrainSpawn;
    private Hex townHall;
    private final HashMap<Hex, Point2D.Double> pixelCoords;

    private HashMap<Hex, MarginHex> marginHexes;

    private HexManager() {
        hexData = new HashMap<>();
        terrainSpawn = new TerrainSpawn(this);
        terrainSpawn.createTerrain(ModelConstants.WORLD_SIZE);

        pixelCoords = new HashMap<>();
        for(Hex hex : hexData.values()) {
            pixelCoords.put(hex, new Point2D.Double(
                    hexToWorldPixelX(hex.getQ(), hex.getR(), HEX_BASE_SIZE),
                    hexToWorldPixelY(hex.getR(), HEX_BASE_SIZE)
            ));
        }
    }
    public static HexManager getInstance() {
        if(instance == null) {
            instance = new HexManager();
        }
        return instance;
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

    public HashMap<Hex, Point2D.Double> getPixelCoords() {
        return pixelCoords;
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

    public Hex getTownHall() {
        return townHall;
    }
    public void setTownHall(Hex townHall) {
        this.townHall = townHall;
    }


    public void putMarginHex(Hex hex, MarginHex marginHex) {
        marginHexes.put(hex, marginHex);
    }

    public MarginHex getMarginHex(Hex hex) {
        if(!marginHexes.containsKey(hex)) return null;
        return marginHexes.get(hex);
    }
}
