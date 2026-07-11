package ap.project.civilization.model.gameplay.unit;

import ap.project.civilization.model.gameplay.ui.MenuAction;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.model.world.unit.units.Worker;

import java.util.List;

public class WorkerUnit extends GeneralUnit {
    @Override
    protected void addActions(Unit unit, List<MenuAction> actions) {
        Worker worker = (Worker) unit;

    }
}
