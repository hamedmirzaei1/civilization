package ap.project.civilization.model.gameplay.unit;

import ap.project.civilization.model.gameplay.ui.MenuAction;
import ap.project.civilization.model.util.ModelConstants;
import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.unit.UnitManager;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.model.world.unit.movement.FogOfWar;
import ap.project.civilization.model.world.unit.units.BorderExpander;

import java.util.List;

public class BorderExpanderUnit extends GeneralUnit {
    @Override
    protected void addActions(Unit unit, List<MenuAction> actions) {
        if(unit.getAp() < ModelConstants.EXPANDING_COST_AP) return;
        if(isAllUnlocked(unit)) return;
        actions.add(new MenuAction("Expand", () -> {
            for(Hex hex : FogOfWar.neighbors(unit.getCurrentHex(), HexManager.getInstance())) {
                if(!hex.isVisible()) continue;
                hex.setUnlock(true);
            }
            unit.getCurrentHex().setUnlock(true);
            ((BorderExpander)unit).resolveExpand();
            UnitManager.getInstance().consumeUnit(unit);
        }));
    }

    private boolean isAllUnlocked(Unit unit) {
        for(Hex hex : FogOfWar.neighbors(unit.getCurrentHex(), HexManager.getInstance())) {
            if(!hex.isUnlock() && hex.isVisible()) return false;
        }
        if(!unit.getCurrentHex().isUnlock()) return false;
        return true;
    }

    @Override
    protected void addDetails(Unit unit, List<String> details) {
        details.add(ModelConstants.EXPANDING_COST_AP + "ap is needed to Expand");
    }
}
