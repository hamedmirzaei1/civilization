package ap.project.civilization.view.render.ui;

import ap.project.civilization.view.util.ui.ViewConstants;

import java.awt.*;

public final class UILayout {
    public static int SIDE_MARGIN = 20;
    public static int SELECTION_MENU_PADDING = 20;
    public static int SELECTION_MENU_SPACING = 10;

    public static Rectangle selectionMenuBounds(int windowWidth, int windowHeight) {
        return new Rectangle(
                SIDE_MARGIN,
                (int) (windowHeight * 0.7),
                (int) (windowWidth * 0.2),
                (int) (windowHeight * 0.3 - (SIDE_MARGIN))
        );
    }

}
