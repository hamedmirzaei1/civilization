package ap.project.civilization.view.render;

import ap.project.civilization.model.GameModel;
import ap.project.civilization.model.hex.Hex;
import ap.project.civilization.model.unit.base.Unit;
import ap.project.civilization.model.unit.base.UnitManager;
import ap.project.civilization.view.render.hex.DrawUnit;
import ap.project.civilization.view.render.hex.HexRenderer;

import java.awt.*;

public class UnitRenderer {
    private final UnitManager unitManager;

    private final HexRenderer renderer;

    public UnitRenderer(GameModel model, HexRenderer renderer) {
        this.unitManager = model.getUnitManager();
        this.renderer = renderer;
    }

    public void renderHexUnits(Graphics2D g2d, Camera camera, Hex hex) {
        for(Unit unit : unitManager.getHexUnitData().get(hex)) {
            DrawUnit.drawUnits(unit, g2d, camera, renderer.getScreenHexSize());
        }
    }
}
