package ap.project.civilization.view.render.ui;

import ap.project.civilization.view.GamePanel;
import ap.project.civilization.view.render.Camera;
import ap.project.civilization.view.render.Renderable;
import ap.project.civilization.view.render.ui.panels.EndTurnButton;
import ap.project.civilization.view.render.ui.panels.ItemMenu;
import ap.project.civilization.view.render.ui.panels.ResourcesPanel;
import ap.project.civilization.view.render.ui.panels.UpdatesPanel;

import java.awt.*;

public class UIRenderer implements Renderable {
    private final ItemMenu itemMenu;
    private final UpdatesPanel updatesPanel;
    private final ResourcesPanel resourcesPanel;
    private EndTurnButton endTurnButton;

    private final GamePanel view;
    public UIRenderer(GamePanel view) {
        this.view = view;
        itemMenu = new ItemMenu();
        updatesPanel = new UpdatesPanel();
        resourcesPanel = new ResourcesPanel();
    }

    @Override
    public void render(Graphics2D g2d, Camera camera) {
        itemMenu.render(g2d, view.getWidth(), view.getHeight());
        updatesPanel.render(g2d, view.getWidth(), view.getHeight());
        resourcesPanel.render(g2d, view.getWidth(), view.getHeight());
        if(endTurnButton != null) endTurnButton.render(g2d);
    }

    public ItemMenu getItemMenu() {
        return itemMenu;
    }

    public void setEndTurnButton(EndTurnButton endTurnButton) {
        this.endTurnButton = endTurnButton;
    }

    public UpdatesPanel getUpdatesPanel() {
        return updatesPanel;
    }

    public ResourcesPanel getResourcesPanel() {
        return resourcesPanel;
    }
}
