package ap.project.civilization.model.ui;

import java.util.List;

public class MenuModel {
    private final List<String> details;
    private final List<MenuAction> actions;

    public MenuModel(List<String> details, List<MenuAction> actions) {
        this.details = details;
        this.actions = actions;
    }

    public List<String> getDetails() {
        return details;
    }

    public List<MenuAction> getActions() {
        return actions;
    }
}
