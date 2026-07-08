package ap.project.civilization.view.util.game;

import java.awt.*;

public final class GameColors {
    private GameColors() {}

    public static final Color FOREST_TERRAIN = new Color(46, 103, 54);
    public static final Color PLAIN_TERRAIN = new Color(201, 185, 118);
    public static final Color MOUNTAIN_TERRAIN = new Color(108, 122, 122);
    public static final Color LAWN_TERRAIN = new Color(120, 175, 57);
    public static final Color TOWN_HALL = new Color(188, 143, 19);

    public static final Color BACKGROUND = new Color(156, 147, 146);

    public static final Color UNLOCK_REGION_BORDER = new Color(154, 110, 2);
    public static final Color SELECTED_BORDER = new Color(166, 39, 47);
    public static final Color MOVABLE_BORDER = new Color(26, 112, 143);

    public static final Color EXPLORER_UNIT = new Color(39, 96, 152);
    public static final Color BORDER_EXPANDER_UNIT = UNLOCK_REGION_BORDER;
}
