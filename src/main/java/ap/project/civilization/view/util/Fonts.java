package ap.project.civilization.view.util;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public final class Fonts {
    private static Font GLOOCK;

    static {
        makeGLOOCK();
    }

    private static void makeGLOOCK() {
        try(InputStream is = Fonts.class.getResourceAsStream("/fonts/Gloock-Regular.ttf")) {
            GLOOCK = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (IOException | FontFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Font GLOOCK(float size) {
        return GLOOCK.deriveFont(size);
    }
}
