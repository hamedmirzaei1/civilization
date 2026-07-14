package ap.project.civilization.model.world.resource;


import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.hexes.HexType;
import ap.project.civilization.view.util.game.AssetManager;

import java.awt.image.BufferedImage;

public enum Resource {
    FOOD("Food"),
    WOOD("Wood"),
    STONE("Stone"),
    IRON("Iron");

    private final String displayName;

    Resource(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public BufferedImage getAsset(Hex hex) {
        if(hex.getType() == HexType.PLAIN) {
            return AssetManager.get("FOOD_MEAT");
        }
        return AssetManager.get(name());
    }

}
