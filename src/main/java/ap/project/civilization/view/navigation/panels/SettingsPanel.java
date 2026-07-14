package ap.project.civilization.view.navigation.panels;

import ap.project.civilization.view.GameFrame;
import ap.project.civilization.view.navigation.components.MenuButton;
import ap.project.civilization.view.navigation.components.MenuLabel;
import ap.project.civilization.view.navigation.components.MenuSlider;
import ap.project.civilization.view.util.game.MusicPlayer;
import ap.project.civilization.view.util.ui.UIColors;

import javax.swing.*;

public class SettingsPanel extends JPanel {
    private MenuButton backBtn;
    private MenuSlider menuSlider;

    public SettingsPanel(GameFrame frame, MusicPlayer player) {
        setPanel();
        createComponents(frame, player);
    }

    private void setPanel() {
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxLayout);

        setBackground(UIColors.MENU_BACKGROUND);
    }

    private void createComponents(GameFrame frame, MusicPlayer player) {
        backBtn = new MenuButton("Back", 18f);
        backBtn.addActionListener(e -> frame.changePage("MENU"));

        menuSlider = new MenuSlider();
        MenuLabel label = new MenuLabel("Sound", 22f);
        menuSlider.addChangeListener(e -> {
            player.setVolume(menuSlider.getValue());
        });

        add(Box.createVerticalGlue());
        add(label);
        add(Box.createVerticalStrut(20));
        add(menuSlider);
        add(Box.createVerticalStrut(80));
        add(backBtn);
        add(Box.createVerticalGlue());

    }
}
