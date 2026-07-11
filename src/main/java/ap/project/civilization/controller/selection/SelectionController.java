package ap.project.civilization.controller.selection;

import ap.project.civilization.model.GameModel;
import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.core.HexCoord;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.view.GamePanel;
import ap.project.civilization.view.render.Camera;
import ap.project.civilization.view.render.hex.CalculateHex;
import ap.project.civilization.view.render.ui.components.UIButton;

import java.awt.event.MouseEvent;

import static ap.project.civilization.view.util.ui.ViewConstants.HEX_BASE_SIZE;

public class SelectionController {
    private final GameModel model;
    private final Camera camera;

    private boolean selectionMode;

    private Unit selectedUnit;
    private Hex selectedHex;
    private Hex lastSelectedHex;

    private final SelectionMenuController menuController;

    public SelectionController(GameModel model, GamePanel view, Camera camera) {
        this.camera = camera;
        this.model = model;

        selectionMode = false;

        menuController = new SelectionMenuController(view.getRenderer().getUiRenderer().getItemMenu());
    }

    public void select(MouseEvent e) {
        double worldX = camera.screenToWorldX(e.getX());
        double worldY = camera.screenToWorldY(e.getY());
        HexCoord coord = CalculateHex.worldPixelToHex(worldX, worldY, HEX_BASE_SIZE);

        if(menuController.handleButtons(e)) {
            unSelect();
            return;
        }

        lastSelectedHex = selectedHex;
        selectedHex = model.getHexManager().getHex(coord);

        if(selectionMode) {
            if(selectedUnit != null && selectedHex != null) {
              selectedUnit.getApproach(selectedHex);
            }
            unSelect();
        }
        else {
            selectUnit(worldX, worldY);

            if(selectedUnit != null) {
                selectedUnit.getFocus();
                selectedHex = null;
                menuController.showMenu(selectedUnit);
            } else {
                selectedHex.setSelected(true);
                menuController.showMenu(selectedHex);
            }
            selectionMode = true;
        }
    }

    private void selectUnit(double x, double y) {
        for(Unit unit : model.getUnitManager().getHexUnitData().get(selectedHex)) {
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
        if(lastSelectedHex != null) {
            lastSelectedHex.setSelected(false);
            lastSelectedHex = null;
        }
        if(selectedHex != null) {
            selectedHex.setSelected(false);
            selectedHex = null;
        }
        if(selectedUnit != null) {
            selectedUnit.setSelected(false);
            selectedUnit = null;
        }

        selectionMode = false;
        menuController.hideMenu();
    }


}
