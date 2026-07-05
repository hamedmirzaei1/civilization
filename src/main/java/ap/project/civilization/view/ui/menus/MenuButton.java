package ap.project.civilization.view.ui.menus;

import ap.project.civilization.view.util.Fonts;
import ap.project.civilization.view.util.UIColors;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuButton extends JButton {
    public MenuButton(String text, float size) {
        setText(text);
        setAlignmentX(JComponent.CENTER_ALIGNMENT);
        setAlignmentY(JComponent.CENTER_ALIGNMENT);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFocusable(false);

        setFont(Fonts.GLOOCK(size));
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
}
