package ap.project.civilization.model.gameplay.ui.menuproviders;

import ap.project.civilization.model.gameplay.ui.MenuModel;
import ap.project.civilization.model.gameplay.unit.BorderExpanderUnit;
import ap.project.civilization.model.gameplay.unit.BuilderUnit;
import ap.project.civilization.model.gameplay.unit.GeneralUnit;
import ap.project.civilization.model.gameplay.unit.WorkerUnit;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.model.world.unit.core.UnitType;

import java.util.HashMap;
import java.util.Map;

public class UnitMenuProvider implements MenuProvider<Unit> {
    private final Map<UnitType, GeneralUnit> creators = new HashMap<>();

    public UnitMenuProvider() {
        creators.put(UnitType.EXPLORER, new GeneralUnit());
        creators.put(UnitType.BORDER_EXPANDER, new BorderExpanderUnit());
        creators.put(UnitType.BUILDER, new BuilderUnit());
        creators.put(UnitType.WORKER, new WorkerUnit());
    }

    @Override
    public MenuModel createMenu(Unit unit) {
        return creators.get(unit.getType()).create(unit);
    }

}
