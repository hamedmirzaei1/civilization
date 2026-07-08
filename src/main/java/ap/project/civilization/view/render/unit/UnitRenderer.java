package ap.project.civilization.view.render.unit;

import ap.project.civilization.model.GameModel;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.model.world.unit.core.UnitManager;
import ap.project.civilization.view.render.Camera;
import ap.project.civilization.view.render.Renderable;
import ap.project.civilization.view.render.hex.HexRenderer;
import ap.project.civilization.view.util.ui.ViewConstants;

import java.awt.*;

public class UnitRenderer implements Renderable {
    private final UnitManager unitManager;
    private final HexRenderer renderer;

    private double unitRenderSize;

    public UnitRenderer(GameModel model, HexRenderer renderer) {
        this.unitManager = model.getUnitManager();
        this.renderer = renderer;
        setUnitRenderSize(ViewConstants.HEX_BASE_SIZE);
    }
    @Override
    public void render(Graphics2D g2d, Camera camera) {
        for(Unit unit : unitManager.getUnits()) {
            setUnitRenderSize(renderer.getScreenHexSize());
            DrawUnit.drawUnits(unit, g2d, camera, unitRenderSize);
        }
    }

    private void setUnitRenderSize(double hexSize) {
        unitRenderSize = hexSize / 3;
    }
}
