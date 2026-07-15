package ap.project.civilization.model.world.resource;

import java.util.EnumMap;
import java.util.Map;

public class Inventory {
    private final Map<Resource, Integer> resources;

    public Inventory() {
        resources = new EnumMap<>(Resource.class);
        for(Resource r : Resource.values()) {
            resources.put(r, 0);
        }
    }

    public int get(Resource resource) {
        return resources.get(resource);
    }

    public boolean add(Resource resource, int amount) {
        if(amount < 0)  {
            return false;
        }
        resources.put(resource, get(resource) + amount);
        return true;
    }

    public int remove(Resource resource, int amount) {
        if(amount < 0)  {
            throw new IllegalArgumentException("negative amount");
        }

        if(get(resource) < amount) {
            int result = get(resource);
            makeEmpty(resource);
            return result;
        }
        resources.put(resource, get(resource) - amount);
        return amount;
    }

    private void makeEmpty(Resource resource) {
        resources.put(resource, 0);
    }


    public boolean contains(Resource resource) {
        return (get(resource) != 0);
    }
    public boolean contains(Resource resource, int amount) {
        return amount < get(resource);
    }

    public Map<Resource, Integer> getResources() {
        return resources;
    }
}
