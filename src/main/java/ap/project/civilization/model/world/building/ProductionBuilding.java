package ap.project.civilization.model.world.building;

import ap.project.civilization.model.world.hex.hexes.Terrain;
import ap.project.civilization.model.world.hex.hexes.TownHall;
import ap.project.civilization.model.world.resource.Inventory;
import ap.project.civilization.model.world.resource.Warehouse;
import ap.project.civilization.model.world.unit.units.Worker;

public class ProductionBuilding extends Building {
    private int productionRate;

    private Worker[] workers;
    private int workerNumbers = 0;
    private int capacity;
    public ProductionBuilding(BuildingType type, Terrain terrain) {
        super(type, terrain);
        workerNumbers = 0;
        this.productionRate = type.getProducingRate();

        capacity = 3;
        workers = new Worker[capacity];
    }

    public void produce() {
        Inventory inventory = ((Terrain)getHex()).getInventory();
        Warehouse warehouse = TownHall.getInstance().getWarehouse();

        int removeAmount = inventory.remove(getType().getResource(), getProductionPerTurn());
        if(removeAmount < getProductionPerTurn()) {
            for(int i=0; i<workerNumbers; i++) {
                workers[i].setEmployed(false);
            }
            getHex().setBuilding(null);
        }

        warehouse.add(getType().getResource(), removeAmount);

    }

    public void addWorker(Worker worker) {
        if(workerNumbers == capacity) throw new IllegalStateException("not enough capacity in building");
        workers[workerNumbers] = worker;
        workerNumbers++;
    }
    public void removeWorker() {
        if(workerNumbers == 0) throw new IllegalStateException("there's no worker to remove from building");
        workerNumbers--;
        workers[workerNumbers] = null;
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

    public int getProductionPerTurn() {
        return productionRate*workerNumbers;
    }
}
