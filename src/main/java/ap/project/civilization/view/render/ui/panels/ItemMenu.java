package ap.project.civilization.view.render.ui.panels;

import ap.project.civilization.model.ui.MenuAction;
import ap.project.civilization.model.ui.MenuModel;
import ap.project.civilization.view.render.ui.components.UIButton;
import ap.project.civilization.view.util.ui.UILayout;
import ap.project.civilization.view.render.ui.components.UIPanel;
import ap.project.civilization.view.util.ui.Fonts;
import ap.project.civilization.view.util.ui.UIColors;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class ItemMenu extends UIPanel{
    private MenuModel menuModel;

    private final List<UIButton> buttons = new ArrayList<>();
    private final Stroke NORMAL = new BasicStroke(4);


    public ItemMenu() {
        super(UILayout.selectionMenuBounds(0, 0),
                UILayout.SELECTION_MENU_PADDING,
                UILayout.SELECTION_MENU_SPACING);

    }

    public void setMenu(MenuModel menuModel) {
        this.menuModel = menuModel;
        if(menuModel == null) {
            hide();
            return;
        }
        createButtons();
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
        bounds.setBounds(UILayout.selectionMenuBounds(panelWidth, panelHeight));
        createButtons();
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
        g2d.setFont(Fonts.GLOOCK(25f));
        g2d.setColor(UIColors.LABEL_LIGHT);

        int margin = g2d.getFontMetrics().getAscent() - g2d.getFontMetrics().getDescent();
        int i=1;
        for(String string : menuModel.getDetails()) {
            if(i > 1) g2d.setFont(Fonts.GLOOCK(18f));
            drawTextOnCenter(g2d, string, i, margin);
            i++;
        }

        for(UIButton btn : buttons) {
            btn.render(g2d);
        }
    }

    private void createButtons() {
        buttons.clear();

        int y = bounds.y + bounds.height/2;

        for(MenuAction action : menuModel.getActions()) {
            Rectangle r = new Rectangle(bounds.x + 30, y, bounds.width - 60, 35);
            buttons.add(new UIButton(r, action.getText(), action.getAction()));
            y += 45;
        }
    }

    private void drawTextOnCenter(Graphics2D g2d, String string, int i, int margin) {
        int stringWidth = g2d.getFontMetrics().stringWidth(string);
        g2d.drawString(string,
                bounds.x + bounds.width/2 - stringWidth/2,
                bounds.y + (margin*i+spacing*(i-1)) + padding);
    }

    public List<UIButton> getButtons() {
        return buttons;
    }
}
