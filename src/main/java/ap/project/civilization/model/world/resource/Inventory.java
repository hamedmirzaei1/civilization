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

    public void add(Resource resource, int amount) {
        if(amount < 1) return;
        resources.put(resource, get(resource) + amount);
    }

    public boolean remove(Resource resource, int amount) {
        if(get(resource) < amount) return false;
        resources.put(resource, get(resource) - amount);
        return true;
    }
}
