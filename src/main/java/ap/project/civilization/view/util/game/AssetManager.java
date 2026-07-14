package ap.project.civilization.view.util.game;

import ap.project.civilization.view.util.ui.ViewConstants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class AssetManager {
    private static final Map<String, BufferedImage> originals = new HashMap<>();
    private static final Map<String, BufferedImage> sprites = new HashMap<>();

    private AssetManager() { }
    static {
        updateScale((int)ViewConstants.HEX_BASE_SIZE);

    }

    public static void loadAll() throws IOException {
        load("/sprites/cow-2.png", "FOOD_MEAT");
        load("/sprites/rock.png", "STONE");
        load("/sprites/tree.png", "WOOD");
        load("/sprites/farm.png", "FOOD");
        load("/sprites/iron.png", "IRON");

        load("/sprites/town-hall.png", "TOWN_HALL");
        load("/sprites/lumber-mill.png", "LUMBER_MILL");
        load("/sprites/field-2.png", "FIELD");
        load("/sprites/stable.png", "STABLE");
        load("/sprites/stone-mine.png", "STONE_MINE");
        load("/sprites/iron-mine.png", "IRON_MINE");





    }

    private static void load(String path, String name) throws IOException {
        try (InputStream in = Objects.requireNonNull(
                AssetManager.class.getResourceAsStream(path),
                "Missing resource: " + path)) {
            BufferedImage image = ImageIO.read(in);
            originals.put(name, image);
            sprites.put(name, image);
        }
    }

    public static void updateScale(int hexSize) {

        sprites.put("WOOD", scale(originals.get("WOOD"), hexSize, hexSize));
        sprites.put("STONE", scale(originals.get("STONE"), hexSize, hexSize));
        sprites.put("FOOD", scale(originals.get("FOOD"), (int)(hexSize * 0.5), (int)(hexSize * 0.5)));
        sprites.put("FOOD_MEAT", scale(originals.get("FOOD_MEAT"), (int)(hexSize * 0.6), (int)(hexSize * 0.6)));
        sprites.put("IRON", scale(originals.get("IRON"), (int)(hexSize * 0.5), (int)(hexSize * 0.5)));

        sprites.put("TOWN_HALL", scale(originals.get("TOWN_HALL"), (int)(hexSize * 1.5), (int)(hexSize * 1.5)));
        sprites.put("LUMBER_MILL", scale(originals.get("LUMBER_MILL"), (int)(hexSize), (int)(hexSize)));
        sprites.put("FIELD", scale(originals.get("FIELD"), (int)(hexSize * 0.8), (int)(hexSize)));
        sprites.put("STABLE", scale(originals.get("STABLE"), (int)(hexSize * 0.9), (int)(hexSize * 0.9)));
        sprites.put("STONE_MINE", scale(originals.get("STONE_MINE"), (int)(hexSize * 0.9), (int)(hexSize * 0.9)));
        sprites.put("IRON_MINE", scale(originals.get("IRON_MINE"), (int)(hexSize), (int)(hexSize)));


    }

    private static BufferedImage scale(BufferedImage src, int width, int height) {

        BufferedImage dst = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = dst.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g.drawImage(src, 0, 0, width, height, null);
        g.dispose();

        return dst;
    }

    public static BufferedImage get(String name) {
        return sprites.get(name);
    }
}