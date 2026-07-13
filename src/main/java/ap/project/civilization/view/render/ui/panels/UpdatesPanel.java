package ap.project.civilization.view.render.ui.panels;

import ap.project.civilization.model.gameplay.ui.MenuModel;
import ap.project.civilization.view.render.ui.components.UILabel;
import ap.project.civilization.view.render.ui.components.UIPanel;
import ap.project.civilization.view.util.ui.UILayout;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UpdatesPanel extends UIPanel {
    MenuModel model;

    private final List<UILabel> labels = new ArrayList<>();
    int items = 0;

    public UpdatesPanel() {
        super(UILayout.updatesPanelBounds(0, 0, 0), 10, 10);
    }

    @Override
    public void updatePanel(int panelWidth, int panelHeight) {
        if(bounds.equals(UILayout.updatesPanelBounds(panelWidth, panelHeight, items))) return;
        bounds.setBounds(UILayout.updatesPanelBounds(panelWidth, panelHeight, items));
    }

    @Override
    public void render(Graphics2D g2d, int panelWidth, int panelHeight) {
        if(model == null) return;
        updatePanel(panelWidth, panelHeight);
        drawPanel(g2d);
        drawComponents(g2d);
    }

    @Override
    public void drawComponents(Graphics2D g2d) {
        for(UILabel label : labels) {
            label.render(g2d);
        }
    }

    private void createComponents() {
        labels.clear();
        items = 0;

        int y = bounds.y + padding;

        for(int i=0; i < model.getDetails().size(); i++) {
            float size = i%2==0 ? 12f : 16f;
            if(i==0) size = 24f;
            Rectangle r = new Rectangle(bounds.x, y, bounds.width, 20);
            labels.add(new UILabel(r, model.getDetails().get(i), size));
            y += 20 + spacing;
            items++;
        }
    }

    public void setModel(MenuModel model) {
        this.model = model;
        createComponents();
    }
}
