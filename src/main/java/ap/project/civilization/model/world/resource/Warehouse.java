package ap.project.civilization.model.world.resource;

public class Warehouse extends Inventory {
    private int capacity;

    public Warehouse(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean add(Resource resource, int amount) {
        if((get(resource) + amount) > capacity) {
            throw new IllegalStateException("Not enough capacity");
        }
        super.add(resource, amount);
        return true;
    }

    public boolean upgrade(int level) {
        switch (level) {
            case 1:
                capacity *= 3;
                return true;
            case 2:
                capacity *=2;
                return true;
        }
        return false;
    }
}
