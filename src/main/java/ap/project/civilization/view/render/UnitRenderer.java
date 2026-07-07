package ap.project.civilization.view.render;

import ap.project.civilization.model.GameModel;
import ap.project.civilization.model.unit.base.Unit;
import ap.project.civilization.model.unit.base.UnitManager;
import ap.project.civilization.view.render.hex.DrawUnit;
import ap.project.civilization.view.render.hex.HexRenderer;

import java.awt.*;

public class UnitRenderer implements Renderable{
    private final UnitManager unitManager;

    private final HexRenderer renderer;

    public UnitRenderer(GameModel model, HexRenderer renderer) {
        this.unitManager = model.getUnitManager();
        this.renderer = renderer;
    }
    @Override
    public void render(Graphics2D g2d, Camera camera) {
        for(Unit unit : unitManager.getUnits()) {
            DrawUnit.drawUnits(unit, g2d, camera, renderer.getScreenHexSize());
        }
    }
}
