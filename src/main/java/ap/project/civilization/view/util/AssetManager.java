package ap.project.civilization.view.util;

import ap.project.civilization.model.terrain.TerrainType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class AssetManager {
    private static final Map<TerrainType, BufferedImage> terrainSprites = new HashMap<>();
    private static final Map<String, BufferedImage> sprites = new HashMap<>();

    private AssetManager() { }

    public static void loadAll() throws IOException {
        loadTerrain("/sprites/cow-2.png", TerrainType.PLAIN);
        loadTerrain("/sprites/rock.png", TerrainType.MOUNTAIN);
        loadTerrain("/sprites/tree.png", TerrainType.FOREST);
        loadTerrain("/sprites/farm.png", TerrainType.LAWN);

        load("/sprites/town-hall.png", "townHall");

    }

    private static void loadTerrain(String path, TerrainType type) throws IOException {
        try (InputStream in = Objects.requireNonNull(
                AssetManager.class.getResourceAsStream(path),
                "Missing resource: " + path)) {
            terrainSprites.put(type, ImageIO.read(in));
        }
    }

    private static void load(String path, String name) throws IOException {
        try (InputStream in = Objects.requireNonNull(
                AssetManager.class.getResourceAsStream(path),
                "Missing resource: " + path)) {
            sprites.put(name, ImageIO.read(in));
        }
    }

    public static BufferedImage get(TerrainType type) {
        return terrainSprites.get(type);
    }
    public static BufferedImage get(String name) {
        return sprites.get(name);
    }
}