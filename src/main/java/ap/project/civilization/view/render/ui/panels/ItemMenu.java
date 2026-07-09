package ap.project.civilization.view.render.ui.panels;

import ap.project.civilization.model.ui.MenuModel;
import ap.project.civilization.view.util.ui.UILayout;
import ap.project.civilization.view.render.ui.components.UIPanel;
import ap.project.civilization.view.util.ui.Fonts;
import ap.project.civilization.view.util.ui.UIColors;

import java.awt.*;


public class ItemMenu extends UIPanel{
    private MenuModel menuModel;

    private final Stroke NORMAL = new BasicStroke(4);
    public ItemMenu() {
        super(UILayout.selectionMenuBounds(0, 0),
                UILayout.SELECTION_MENU_PADDING,
                UILayout.SELECTION_MENU_SPACING);

    }

    public void setMenu(MenuModel menuModel) {
        this.menuModel = menuModel;
    }
    public void updateLayout(int panelWidth, int panelHeight) {
        bounds.setBounds(UILayout.selectionMenuBounds(panelWidth, panelHeight));
    }

    public void render(Graphics2D g2d) {
        if(menuModel == null) return;

        g2d.setColor(UIColors.LIGHT_MENU_BACKGROUND);
        g2d.fillRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, 10, 10);

        g2d.setColor(UIColors.LIGHT_MENU_BORDER);
        g2d.setStroke(NORMAL);
        g2d.drawRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, 10, 10);

        g2d.setFont(Fonts.GLOOCK(25f));
        g2d.setColor(UIColors.LABEL_LIGHT);
        int margin = g2d.getFontMetrics().getAscent() - g2d.getFontMetrics().getDescent();

        int i=1;
        for(String s : menuModel.getDetails()) {
            if(i > 1) g2d.setFont(Fonts.GLOOCK(18f));
            int stringWidth = g2d.getFontMetrics().stringWidth(s);
            g2d.drawString(s,
                    bounds.x + bounds.width/2 - stringWidth/2,
                    bounds.y + (margin*i+spacing*(i-1)) + padding);
            i++;
        }
    }
}
