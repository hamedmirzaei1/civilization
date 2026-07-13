package ap.project.civilization.view.render.ui.panels;

import ap.project.civilization.model.gameplay.ui.MenuAction;
import ap.project.civilization.model.gameplay.ui.MenuModel;
import ap.project.civilization.view.render.ui.components.UIButton;
import ap.project.civilization.view.render.ui.components.UILabel;
import ap.project.civilization.view.util.ui.UILayout;
import ap.project.civilization.view.render.ui.components.UIPanel;
import ap.project.civilization.view.util.ui.UIColors;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class ItemMenu extends UIPanel{
    private MenuModel menuModel;

    private final List<UIButton> buttons = new ArrayList<>();
    private final List<UILabel> labels = new ArrayList<>();
    private int items = 0;

    private final Stroke NORMAL = new BasicStroke(4);

    public ItemMenu() {
        super(UILayout.selectionMenuBounds(0, 0, 0),
                UILayout.SELECTION_MENU_PADDING,
                UILayout.SELECTION_MENU_SPACING);

    }

    public void setMenu(MenuModel menuModel) {
        this.menuModel = menuModel;
        if(menuModel == null) {
            hide();
            return;
        }
        createComponents();
        show();
    }

    @Override
    public void render(Graphics2D g2d, int panelWidth, int panelHeight) {
        if(!isVisible()) return;
        updateLayout(panelWidth, panelHeight);

        drawPanel(g2d);
        drawComponents(g2d);
    }

    public void updateLayout(int panelWidth, int panelHeight) {
        if(bounds.equals(UILayout.selectionMenuBounds(panelWidth, panelHeight, items))) return;

        bounds.setBounds(UILayout.selectionMenuBounds(panelWidth, panelHeight, items));
        createComponents();
    }


    @Override
    public void drawPanel(Graphics2D g2d) {
        g2d.setColor(UIColors.LIGHT_MENU_BACKGROUND);
        g2d.fillRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, 10, 10);

        g2d.setColor(UIColors.LIGHT_MENU_BORDER);
        g2d.setStroke(NORMAL);
        g2d.drawRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, 10, 10);
    }

    @Override
    public void drawComponents(Graphics2D g2d) {
        for(UILabel label : labels) {
            label.render(g2d);
        }

        for(UIButton btn : buttons) {
            btn.render(g2d);
        }
    }

    private void createComponents() {
        buttons.clear();
        labels.clear();
        items = 0;

        int y = bounds.y + padding;

        for(int i=0; i < menuModel.getDetails().size(); i++) {
            float size = i==0 ? 24f : 18f;
            Rectangle r = new Rectangle(bounds.x, y, bounds.width, 20);
            labels.add(new UILabel(r, menuModel.getDetails().get(i), size));
            y += 20 + spacing;
            items++;
        }

        y += spacing;

        for(MenuAction action : menuModel.getActions()) {
            Rectangle r = new Rectangle(bounds.x + 30, y, bounds.width - 60, 35);
            buttons.add(new UIButton(r, action.getText(), action.getAction(), true));
            y += 35 + spacing;
            items++;
        }

    }

    public List<UIButton> getButtons() {
        return buttons;
    }
}
