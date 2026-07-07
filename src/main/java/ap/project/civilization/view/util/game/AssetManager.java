package ap.project.civilization.view.util.game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class AssetManager {
    private static final Map<String, BufferedImage> sprites = new HashMap<>();

    private AssetManager() { }

    public static void loadAll() throws IOException {
        load("/sprites/cow-2.png", "COW");
        load("/sprites/rock.png", "ROCK");
        load("/sprites/tree.png", "TREE");
        load("/sprites/farm.png", "FARM");
        load("/sprites/iron.png", "IRON");

        load("/sprites/town-hall.png", "TOWN_HALL");

    }



    private static void load(String path, String name) throws IOException {
        try (InputStream in = Objects.requireNonNull(
                AssetManager.class.getResourceAsStream(path),
                "Missing resource: " + path)) {
            sprites.put(name, ImageIO.read(in));
        }
    }


    public static BufferedImage get(String name) {
        return sprites.get(name);
    }
}