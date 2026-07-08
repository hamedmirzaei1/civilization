package ap.project.civilization.model.world.terrain;

import ap.project.civilization.model.world.hex.Hex;
import ap.project.civilization.model.world.hex.HexCoord;

public class Terrain extends Hex {
    private TerrainType terrainType;

    public Terrain(HexCoord coordinate, TerrainType terrainType) {
        super(coordinate);

        this.terrainType = terrainType;
        setVisible(false);
    }

    public TerrainType getTerrainType() {
        return terrainType;
    }
}
