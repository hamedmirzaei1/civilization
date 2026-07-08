package ap.project.civilization.controller.selection;

import ap.project.civilization.model.GameModel;
import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.hex.HexCoord;
import ap.project.civilization.model.unit.core.Unit;
import ap.project.civilization.view.render.Camera;
import ap.project.civilization.view.render.hex.CalculateHex;

import java.awt.event.MouseEvent;

import static ap.project.civilization.view.util.ui.ViewConstants.HEX_BASE_SIZE;

public class SelectionController {
    private final GameModel model;
    private final Camera camera;

    private boolean selectionMode;
    private Unit selectedUnit;

    private Hex selectedHex;
    private Hex lastSelectedHex;

    public SelectionController(GameModel model, Camera camera) {
        this.camera = camera;
        this.model = model;

        selectionMode = false;
    }

    public void select(MouseEvent e) {
        double worldX = camera.screenToWorldX(e.getX());
        double worldY = camera.screenToWorldY(e.getY());
        HexCoord coord = CalculateHex.worldPixelToHex(worldX, worldY, HEX_BASE_SIZE);

        lastSelectedHex = selectedHex;
        selectedHex = model.getHexManager().getHex(coord);

        if(selectionMode) {
            if(selectedUnit != null && selectedHex != null) {
              selectedUnit.getApproach(selectedHex);
            }
            unSelect();
            selectionMode = false;
        }
        else {
            selectUnit(worldX, worldY);

            if(selectedUnit != null) {
                selectedUnit.getFocus();
                selectedHex = null;
            } else {
                model.getHexManager().getHex(coord).setSelected(true);
            }
            selectionMode = true;
        }
    }

    private void selectUnit(double x, double y) {
        for(Unit unit : model.getUnitManager().getHexUnitData().get(selectedHex)) {  //todo: scale to 6 neighbors
            if(unit.getMovement().isMoving()) return;

            double dx = x - unit.getMovement().getX();
            double dy = y - unit.getMovement().getY();

            if(dx*dx + dy*dy <= HEX_BASE_SIZE/6 * HEX_BASE_SIZE/6) {
                selectedUnit = unit;
                unit.setSelected(true);
                selectionMode = true;

            }
        }
    }

    public void unSelect() {
        if(lastSelectedHex != null) lastSelectedHex.setSelected(false);
        lastSelectedHex = null;
        if(selectedUnit != null) selectedUnit.setSelected(false);
        selectedUnit = null;
    }

    public boolean isSelectionMode() {
        return selectionMode;
    }

    public void onHexExplore() {
//        if(selectedHex != null) //todo : use a method in model for removing fog of war
    }
}
