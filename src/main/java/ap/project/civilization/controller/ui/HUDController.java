package ap.project.civilization.controller.ui;

import ap.project.civilization.model.gameplay.hud.Updates;
import ap.project.civilization.view.GamePanel;
import ap.project.civilization.view.render.ui.panels.UpdatesPanel;

public class HUDController {

    private final UpdatesPanel updatesPanel;
    public HUDController(GamePanel view) {
        updatesPanel = view.getRenderer().getUiRenderer().getUpdatesPanel();
    }

    public void update() {
        updatesPanel.setModel(Updates.create());
    }
}
