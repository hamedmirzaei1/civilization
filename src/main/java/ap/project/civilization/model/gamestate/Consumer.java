package ap.project.civilization.model.gamestate;


import ap.project.civilization.model.world.hex.hexes.TownHall;
import ap.project.civilization.model.world.resource.Resource;
import ap.project.civilization.model.world.resource.Warehouse;

import java.util.Set;

public class Consumer {
    private static final int consumingRate = 5;

    public static void consume(Set<Resource> resources) {
        Warehouse warehouse = TownHall.getInstance().getWarehouse();
        for (Resource r : resources) {
            warehouse.remove(r, consumingRate);
        }
    }
    public static boolean canConsume(Set<Resource> resource) {
        Warehouse warehouse = TownHall.getInstance().getWarehouse();
        for (Resource r : resource) {
            if (!warehouse.contains(r, consumingRate)) return false;
        }
        return true;
    }
}
