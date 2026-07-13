package ap.project.civilization.model.gameplay.hud;

import ap.project.civilization.model.gameplay.ui.MenuAction;
import ap.project.civilization.model.gameplay.ui.MenuModel;
import ap.project.civilization.model.world.hex.hexes.TownHall;
import ap.project.civilization.model.world.resource.Resource;
import ap.project.civilization.model.world.resource.Warehouse;

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

        return new MenuModel(details, actions);
    }
}
