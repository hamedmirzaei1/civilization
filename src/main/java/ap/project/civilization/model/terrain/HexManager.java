package ap.project.civilization.model.terrain;

public class HexManager {
    private Hex[][] hexes;
    public HexManager() {
        hexes = new Hex[9][9];

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                hexes[i][j] = new Hex(i, j);
            }
        }
    }

    public Hex[][] getHexes() {
        return hexes;
    }
}
