package ap.project.civilization.model.world.resource;

public class Warehouse extends Inventory {
    private int capacity;
    private int level;

    public Warehouse(int capacity) {
        super();
        this.capacity = capacity;
        level = 0;
    }

    @Override
    public boolean add(Resource resource, int amount) {
        if((get(resource) + amount) > capacity) {
            makeFull(resource);
            return false;
        }
        super.add(resource, amount);
        return true;
    }

    public void upgrade() {
        switch (level) {
            case 0:
                capacity *= 3;
                level++;
                break;
            case 1:
                capacity *=2;
                level++;
        }
    }
    private void makeFull(Resource resource) {
        getResources().put(resource, capacity);
    }

    public boolean isUpgradable() {
        return level<2;
    }
    public int getLevel() {
        return level;
    }

    public int getCapacity() {
        return capacity;
    }
}
