package ap.project.civilization.controller.ui;

import ap.project.civilization.model.gameplay.hud.Resources;
import ap.project.civilization.model.gameplay.hud.Updates;
import ap.project.civilization.view.GamePanel;
import ap.project.civilization.view.render.ui.panels.ResourcesPanel;
import ap.project.civilization.view.render.ui.panels.UpdatesPanel;

public class HUDController {

    private final UpdatesPanel updatesPanel;
    private final ResourcesPanel resourcesPanel;

    public HUDController(GamePanel view) {
        updatesPanel = view.getRenderer().getUiRenderer().getUpdatesPanel();
        resourcesPanel = view.getRenderer().getUiRenderer().getResourcesPanel();
    }

    public void update() {
        updatesPanel.setModel(Updates.create());
        resourcesPanel.setModel(Resources.create());
    }
}
