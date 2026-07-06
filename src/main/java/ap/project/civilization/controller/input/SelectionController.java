package ap.project.civilization.controller.input;

import ap.project.civilization.controller.GameController;
import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.hex.HexCoord;
import ap.project.civilization.view.render.Camera;
import ap.project.civilization.view.render.hex.CalculateHex;

import java.awt.event.MouseEvent;

import static ap.project.civilization.view.util.ViewConstants.HEX_BASE_SIZE;

public class SelectionController {
    private final GameController controller;
    private final Camera camera;

    private boolean SelectionMode;

    private Hex selectedHex;

    public SelectionController(GameController controller, Camera camera) {
        this.camera = camera;
        this.controller = controller;

        SelectionMode = false;
    }
    public void select(MouseEvent e) {
        double worldX = camera.screenToWorldX(e.getX());
        double worldY = camera.screenToWorldY(e.getY());
        HexCoord coord = CalculateHex.worldPixelToHex(worldX, worldY, HEX_BASE_SIZE);

        if(SelectionMode) {
            SelectionMode = false;
            unSelect();
        }
        else {
            selectedHex = controller.getModel().getHexManager().getHex(coord);
            controller.getModel().getHexManager().getHex(coord).setSelected(true);
            SelectionMode = true;
        }
    }

    public boolean isSelectionMode() {
        return SelectionMode;
    }

    public void unSelect() {
        SelectionMode = false;
        if(selectedHex != null) selectedHex.setSelected(false);

    }
}
