package ap.project.civilization.model.gameplay.unit;

import ap.project.civilization.model.gameplay.ui.MenuAction;
import ap.project.civilization.model.gameplay.ui.MenuModel;
import ap.project.civilization.model.world.building.BuildingType;
import ap.project.civilization.model.world.building.ProductionBuilding;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.model.world.unit.units.Worker;

import java.util.ArrayList;
import java.util.List;

public class WorkerUnit extends GeneralUnit {
    @Override
    public MenuModel create(Unit unit) {
        Worker worker = (Worker) unit;

        List<String> details = new ArrayList<>();
        List<MenuAction> actions = new ArrayList<>();

        details.add(unit.getType().getDisplayName());
        details.add("ap:  " + unit.getAp() + " of  " + worker.getMaxAP());



        if(canBeEmployed(worker)) {
            ProductionBuilding building = (ProductionBuilding) unit.getCurrentHex().getBuilding();
            actions.add(new MenuAction("Employ", () -> {
            worker.setEmployed(true);
            building.addWorker();
            }));
        }
        if(worker.isEmployed()){
            ProductionBuilding building = (ProductionBuilding) unit.getCurrentHex().getBuilding();
            actions.add(new MenuAction("Un-employ", () -> {
                worker.setEmployed(false);
                building.removeWorker();
            }));
        }

        return new MenuModel(details, actions);
    }

    private boolean canBeEmployed(Worker worker) {
        if(worker.isEmployed()) return false;
        if(!worker.getCurrentHex().hasBuilding()) return false;
        if(worker.getCurrentHex().getBuilding().getType() == BuildingType.TOWN_HALL ||
                worker.getCurrentHex().getBuilding().getType() == BuildingType.TOWN) return false;
        ProductionBuilding building = (ProductionBuilding) worker.getCurrentHex().getBuilding();
        if(!building.hasCapacity()) return false;
        return true;
    }

}
