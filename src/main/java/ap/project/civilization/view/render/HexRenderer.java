package ap.project.civilization.view.render;

import ap.project.civilization.model.GameModel;
import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.hex.HexCoord;
import ap.project.civilization.model.terrain.Terrain;
import ap.project.civilization.view.ui.Camera;
import ap.project.civilization.view.util.AssetManager;
import ap.project.civilization.view.util.ViewConstants;

import java.awt.*;

import static ap.project.civilization.view.render.MakeHex.*;

public class HexRenderer implements Renderable{
    private final GameModel model;


    public HexRenderer(GameModel model) {
        this.model = model;
    }

    @Override
    public void render(Graphics2D g2d, Camera camera) {
        double renderHexSize = ViewConstants.HEX_BASE_SIZE * camera.getZoom();

        HexCoord cameraHexCoord = pixelToHex(camera.getScreenX(), camera.getScreenY(), renderHexSize);
        int numberQ = (int)(ViewConstants.getWindowWidth()/ renderHexSize);
        int numberR = (int)(ViewConstants.getWindowHeight()/ renderHexSize);

        for(Hex hex : model.getHexManager().getHexes(
                cameraHexCoord.getQ()-numberQ,
                cameraHexCoord.getR(),
                cameraHexCoord.getQ()+numberQ,
                cameraHexCoord.getR()+numberR
                )) {
            draw(g2d, camera, hex, renderHexSize);
        }
    }

    private void draw(Graphics2D g2d, Camera camera, Hex hex, double size) {
        double x = hexToPixelX(hex.getQ(), hex.getR(), size);
        double y = hexToPixelY(hex.getR(), size);

        x = camera.worldToScreenX(x);
        y = camera.worldToScreenY(y);

        Polygon polygon = MakeHex.hexShape(x, y, size);

        if(hex.isVisible()) { // todo : refactor and scale architecture, make renderer lazy
            g2d.setColor(((Terrain)hex).getTerrainType().getColor());
            g2d.fill(polygon);
            g2d.drawImage(AssetManager.get(((Terrain)hex).getTerrainType()), (int)x, (int)y, (int)size/2, (int)size/2, null);
        }

        g2d.setColor(Color.DARK_GRAY);
        g2d.drawPolygon(polygon);
    }


}
