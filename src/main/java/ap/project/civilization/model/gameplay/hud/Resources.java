package ap.project.civilization.model.gameplay.hud;

import ap.project.civilization.model.gameplay.ui.MenuAction;
import ap.project.civilization.model.gameplay.ui.MenuModel;
import ap.project.civilization.model.world.hex.hexes.TownHall;
import ap.project.civilization.model.world.resource.Resource;
import ap.project.civilization.model.world.resource.Warehouse;
import ap.project.civilization.model.world.unit.UnitManager;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.model.world.unit.core.UnitType;

import java.util.ArrayList;
import java.util.List;

public class Resources {
    public static MenuModel create() {
        List<String> details = new ArrayList<>();
        List<MenuAction> actions = new ArrayList<>();

        Warehouse warehouse = TownHall.getInstance().getWarehouse();

        for(Resource resource : Resource.values()) {
            details.add(resource.getDisplayName() +
                    ": " + warehouse.get(resource) + " of  " +
                    warehouse.getCapacity());
        }

        details.add("Units: " + UnitManager.getInstance().getUnits().size() + " of " + TownHall.getInstance().getUnitCapacity());
        int workers = 0;
        int builders = 0;
        int explorers = 0;
        int bExpanders = 0;
        for(Unit unit : UnitManager.getInstance().getUnits()) {
            if(unit.getType() == UnitType.WORKER) workers++;
            if(unit.getType() == UnitType.BUILDER) builders++;
            if(unit.getType() == UnitType.EXPLORER) explorers++;
            if(unit.getType() == UnitType.BORDER_EXPANDER) bExpanders++;
        }
        details.add("Workers: " + workers);
        details.add("Builders: " + builders);
        details.add("Explorers: " + explorers);
        details.add("Border Expanders: " + bExpanders);
        return new MenuModel(details, actions);
    }
}
