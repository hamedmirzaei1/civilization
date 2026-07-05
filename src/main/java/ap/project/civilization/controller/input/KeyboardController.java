package ap.project.civilization.controller.input;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Set;

public class KeyboardController {
    private final Set<Integer> pressed = new HashSet<>();

    public KeyboardController(JComponent component) {
        bind(component, "W");
        bind(component, "A");
        bind(component, "S");
        bind(component, "D");


        bind(component, "EQUALS");
        bind(component, "MINUS");
    }

    private void bind(JComponent component, String key) {

        InputMap im = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = component.getActionMap();

        im.put(KeyStroke.getKeyStroke("pressed " + key), "pressed_" + key);
        im.put(KeyStroke.getKeyStroke("released " + key), "released_" + key);

        int keyCode = KeyStroke.getKeyStroke(key).getKeyCode();

        am.put("pressed_" + key, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressed.add(keyCode);
            }
        });

        am.put("released_" + key, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressed.remove(keyCode);
            }
        });
    }

    public boolean isPressed(int keyCode) {
        return pressed.contains(keyCode);
    }
}
