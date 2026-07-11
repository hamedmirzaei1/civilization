package ap.project.civilization.model.gameplay.unit;

import ap.project.civilization.model.gameplay.ui.MenuAction;
import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.unit.UnitManager;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.model.world.unit.movement.FogOfWar;

import java.util.List;

public class BorderExpanderUnit extends GeneralUnit {
    @Override
    protected void addActions(Unit unit, List<MenuAction> actions) {
        if(isAllUnlocked(unit)) return;
        actions.add(new MenuAction("Expand", () -> {
            for(Hex hex : FogOfWar.neighbors(unit.getCurrentHex(), HexManager.getInstance())) {
                if(!hex.isVisible()) continue;
                hex.setUnlock(true);
            }
            unit.getCurrentHex().setUnlock(true);
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
}
