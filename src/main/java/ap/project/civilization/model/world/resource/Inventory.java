package ap.project.civilization.model.world.resource;

import java.util.EnumMap;
import java.util.Map;

public class Inventory {
    private final Map<Resource, Integer> resources = new EnumMap<>(Resource.class);

    public Inventory() {
        for(Resource r : Resource.values()) {
            resources.put(r, 0);
        }
    }

    public int get(Resource resource) {
        return resources.get(resource);
    }

    public boolean add(Resource resource, int amount) {
        if(amount < 1)  {
            throw new IllegalArgumentException("negative amount of resource");
        }
        resources.put(resource, get(resource) + amount);
        return true;
    }

    public boolean remove(Resource resource, int amount) {
        if(amount < 1)  {
            throw new IllegalArgumentException("negative amount of resource");
        }

        if(get(resource) < amount) return false;
        resources.put(resource, get(resource) - amount);
        return true;
    }

    public boolean Contains(Resource resource) {
        return (get(resource) != 0);
    }
}
