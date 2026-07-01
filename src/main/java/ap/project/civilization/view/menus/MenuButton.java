package ap.project.civilization.view.menus;

import ap.project.civilization.view.util.FontManager;
import ap.project.civilization.view.util.UIColors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuButton extends JButton {
    public MenuButton(String text) {
        Font font = FontManager.getInstance().getGloock();

        setText(text);
        setAlignmentX(JComponent.CENTER_ALIGNMENT);
        setAlignmentY(JComponent.CENTER_ALIGNMENT);
        setHorizontalAlignment(SwingConstants.LEFT);
        setFocusable(false);

        setFont(font);
        setBorderPainted(false);
        setForeground(UIColors.BUTTON);

        addHoverEffect();
    }

    private void addHoverEffect() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(UIColors.HOVERED_BUTTON);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(UIColors.BUTTON);
            }
        });
    }

    public static void makeSameWidth(JButton... buttons) {
        int width = 0;

        for (JButton button : buttons) {
            width = Math.max(width, button.getPreferredSize().width);
        }

        for (JButton button : buttons) {
            Dimension size = new Dimension(width, button.getPreferredSize().height);
            button.setMaximumSize(size);
        }
    }
}
