package ap.project.civilization.model.world.hex.hexes;

import ap.project.civilization.model.world.hex.core.Hex;

public class MarginHex {

    private Hex firstHex;
    private Hex secondHex;
    private MarginHexType type;

    public MarginHex(MarginHexType type, Hex firstHex, Hex secondHex) {
        this.firstHex = firstHex;
        this.secondHex = secondHex;

        this.type = type;
    }


}
