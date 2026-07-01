package ap.project.civilization.view.util;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class FontManager {
    private static FontManager instance;

    private Font gloock;

    private FontManager() {
        initGloock();
    }

    public static FontManager getInstance() {
        if(instance == null) {
            instance = new FontManager();
        }
        return instance;
    }

    private void initGloock() {
        InputStream is = getClass().getResourceAsStream("/fonts/Gloock-Regular.ttf");
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            font = font.deriveFont(24f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
            gloock = font;
        } catch (IOException | FontFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public Font getGloock() {
        return gloock;
    }
}
