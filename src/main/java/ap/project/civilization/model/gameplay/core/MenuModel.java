package ap.project.civilization.model.gameplay.core;

import java.awt.*;
import java.util.Collections;
import java.util.List;

public class MenuModel {
    private final List<String> details;
    private final List<MenuAction> actions;
    private final List<Color> colors;

    public MenuModel(List<String> details, List<MenuAction> actions) {
        this(details, actions, Collections.emptyList());
    }

    public MenuModel(List<String> details, List<MenuAction> actions, List<Color> colors) {
        this.details = details;
        this.actions = actions;
        this.colors = colors;
    }

    public List<String> getDetails() {
        return details;
    }

    public List<MenuAction> getActions() {
        return actions;
    }

    public List<Color> getColors() {
        return colors;
    }
}
