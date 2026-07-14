package ap.project.civilization.view.navigation.components;

import ap.project.civilization.view.util.ui.Fonts;
import ap.project.civilization.view.util.ui.UIColors;

import javax.swing.*;

public class MenuLabel extends JLabel {
    public MenuLabel(String text, float size) {
        super(text);
        setFont(Fonts.GLOOCK(size));
        setAlignmentX(JComponent.CENTER_ALIGNMENT);
        setForeground(UIColors.LABEL);
    }
}
