package ap.project.civilization.view.util.ui;

import java.awt.*;

public final class UILayout {
    public static int SIDE_MARGIN = 20;
    public static int SELECTION_MENU_PADDING = 20;
    public static int SELECTION_MENU_SPACING = 15;


    public static Rectangle selectionMenuBounds(int windowWidth, int windowHeight, int items) {
        int height = items * 55;
        return new Rectangle(
                SIDE_MARGIN,
                (int) (windowHeight - height - SIDE_MARGIN),
                (int) (windowWidth * 0.2),
                (int) (height)
        );
    }
}
