package ap.project.civilization.model.gameplay.core;

public class MenuAction {
    private final String text;
    private final Runnable action;

    public MenuAction(String text, Runnable action) {
        this.text = text;
        this.action = action;
    }

    public String getText() {
        return text;
    }

    public Runnable getAction() {
        return action;
    }
}
