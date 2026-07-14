package ap.project.civilization.view.navigation.components;

import ap.project.civilization.view.util.ui.UIColors;

import javax.swing.*;
import java.awt.*;

public class ConfirmationDialog extends JDialog {
    private boolean confirmed = false;

    public ConfirmationDialog(Frame owner, String message) {
        super(owner, "dialog", true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setSize(350, 180);
        setLocationRelativeTo(owner);
        setResizable(false);

        JPanel panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setBackground(UIColors.MENU_BACKGROUND);
        panel.setBorder(BorderFactory.createLineBorder(UIColors.LIGHT_MENU_BACKGROUND, 3));

        MenuLabel label = new MenuLabel(message, 20f);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        MenuButton yesButton = new MenuButton("Yes", 24f);
        MenuButton noButton = new MenuButton("No", 24f);

        yesButton.addActionListener(e -> {
            confirmed = true;
            dispose();
        });

        noButton.addActionListener(e -> {
            confirmed = false;
            dispose();
        });

        buttonPanel.add(noButton);
        buttonPanel.add(yesButton);

        panel.add(Box.createVerticalGlue());
        panel.add(label, BorderLayout.CENTER);
        panel.add(Box.createVerticalGlue());
        panel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(Box.createVerticalGlue());

        setContentPane(panel);
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public static boolean show(Frame owner, String message) {
        ConfirmationDialog dialog = new ConfirmationDialog(owner, message);

        dialog.setVisible(true);
        return dialog.isConfirmed();
    }
}
