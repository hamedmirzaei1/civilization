package ap.project.civilization.model.world.building;

import ap.project.civilization.model.world.hex.hexes.Terrain;
import ap.project.civilization.model.world.hex.hexes.TownHall;
import ap.project.civilization.model.world.resource.Inventory;
import ap.project.civilization.model.world.resource.Warehouse;

public class ProductionBuilding extends Building {
    private boolean active;
    private int productionRate;

    private int workerNumbers;
    private int capacity;
    public ProductionBuilding(BuildingType type, Terrain terrain) {
        super(type, terrain);

        active = false;
        this.productionRate = type.getProducingRate();

        workerNumbers = 0;
        capacity = 3;
    }

    public void produce() {
        Inventory inventory = ((Terrain)getHex()).getInventory();
        Warehouse warehouse = TownHall.getInstance().getWarehouse();

        if(!inventory.contains(getType().getResource())) return;
        inventory.remove(getType().getResource(), productionRate*workerNumbers);
        warehouse.add(getType().getResource(), productionRate*workerNumbers);

    }

    public void addWorker() {
        if(workerNumbers+1 > capacity) throw new IllegalStateException("not enough capacity in building");
        workerNumbers++;
    }
    public void removeWorker() {
        if(workerNumbers-1 < 0) throw new IllegalStateException("there's no worker to remove from building");
        workerNumbers--;
    }
    public boolean hasCapacity() {
        return workerNumbers < capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getWorkerNumbers() {
        return workerNumbers;
    }
}
