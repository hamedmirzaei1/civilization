package ap.project.civilization.view.render.hex;

import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.view.util.game.GameColors;

import java.awt.*;

public class DrawHexLogic {
    public static Color borderColor(Hex hex) {
        if(hex.isSelected()) {
            return GameColors.SELECTED_BORDER;
        }
        if(hex.isMovable()) {
            return GameColors.MOVABLE_BORDER;
        }
        if(hex.isUnlock()) {
            return GameColors.UNLOCK_REGION_BORDER;
        } else {
            return Color.DARK_GRAY;
        }

    }
}
