package ap.project.civilization.model.terrain;

import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.hex.HexCoord;

public class Terrain extends Hex {
    private TerrainType terrainType;

    public Terrain(HexCoord coordinate, TerrainType terrainType) {
        super(coordinate);

        this.terrainType = terrainType;
    }

    public TerrainType getTerrainType() {
        return terrainType;
    }
}
