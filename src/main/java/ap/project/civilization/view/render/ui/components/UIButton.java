package ap.project.civilization.view.render.ui.components;

import java.awt.*;

public class UIButton {
    private Rectangle Bounds;
    private String text;
    private Runnable action;

    public void click() {
        action.run();
    }
}
