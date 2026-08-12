package ap.project.civilization.model.gamestate;

import ap.project.civilization.model.world.hex.hexes.TownHall;
import ap.project.civilization.model.world.resource.Resource;
import ap.project.civilization.model.world.resource.Warehouse;

public class CentralTransaction {
    private static CentralTransaction instance;

    public static CentralTransaction getInstance() {
        if(instance == null)
            instance = new CentralTransaction();
        return instance;
    }

    private Warehouse townHallWarehouse;

    public CentralTransaction() {
        townHallWarehouse = TownHall.getInstance().getWarehouse();
    }

    public boolean canAfford(Cost cost) {
        for(Resource resource : cost.getAll().keySet()) {
            if(!townHallWarehouse.contains(resource)) return false;
        }
        return true;
    }

    public void pay(Cost cost) {
        for(Resource resource : cost.getAll().keySet()) {
            townHallWarehouse.remove(resource, cost.get(resource));
        }
    }
}
