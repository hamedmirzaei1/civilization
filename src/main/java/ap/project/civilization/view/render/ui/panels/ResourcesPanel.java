package ap.project.civilization.view.render.ui.panels;

import ap.project.civilization.model.gameplay.ui.MenuModel;
import ap.project.civilization.view.render.ui.components.UILabel;
import ap.project.civilization.view.render.ui.components.UIPanel;
import ap.project.civilization.view.util.ui.UIColors;
import ap.project.civilization.view.util.ui.UILayout;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ResourcesPanel extends UIPanel {
    MenuModel model;

    private final List<UILabel> labels = new ArrayList<>();

    public ResourcesPanel() {
        super(UILayout.resourcePanelBounds(0, 0), 10, 4);
    }

    @Override
    public void updatePanel(int panelWidth, int panelHeight) {
        if(bounds.equals(UILayout.resourcePanelBounds(panelWidth, panelHeight))) return;
        bounds.setBounds(UILayout.resourcePanelBounds(panelWidth, panelHeight));
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
        int x = bounds.x;
        int width = bounds.width/4;
        for(int i=1; i<4; i++) {
            g2d.setStroke(new BasicStroke(4));
            g2d.setColor(UIColors.LIGHT_MENU_BORDER);
            g2d.drawLine(x+width*i, bounds.y, x+width*i, bounds.y+bounds.height/2);
        }
        g2d.drawLine(x, bounds.y+ bounds.height/2, x+bounds.width, bounds.y + bounds.height/2);
        width = bounds.width/5;
        for(int i=1; i<6; i++) {
            g2d.setStroke(new BasicStroke(4));
            g2d.setColor(UIColors.LIGHT_MENU_BORDER);
            g2d.drawLine(x+width*i, bounds.y + bounds.height/2, x+width*i, bounds.y+bounds.height);
        }
    }

    private void createComponents() {
        labels.clear();

        int x = bounds.x;

        for(int i=0; i < 4; i++) {
            Rectangle r = new Rectangle(x, bounds.y+padding, bounds.width/4, bounds.height/3);
            labels.add(new UILabel(r, model.getDetails().get(i), 18f));
            x += bounds.width/4;
        }
        x = bounds.x;
        for(int i=4; i < model.getDetails().size(); i++) {
            Rectangle r = new Rectangle(x, bounds.y + (int)(bounds.height * 0.6), bounds.width/5, bounds.height/3);
            float size = i==4 ? 18f : 14f;
            labels.add(new UILabel(r, model.getDetails().get(i), size));
            x += bounds.width/5;
        }
    }

    public void setModel(MenuModel model) {
        this.model = model;
        createComponents();
    }
}
