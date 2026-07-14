package ap.project.civilization.view.navigation.components;

import ap.project.civilization.view.util.ui.ViewConstants;

import javax.swing.*;
import java.awt.*;

public class MenuSlider extends JSlider {
    public MenuSlider() {

        setMinimumSize(new Dimension(400, 50));
        setMaximumSize(new Dimension(400, 50));
        setMinimum(0);
        setMaximum(100);
        setValue(ViewConstants.INIT_MUSIC_VOLUME);
    }
}
