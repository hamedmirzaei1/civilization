package ap.project.civilization.model.gamestate;

import ap.project.civilization.model.world.resource.Resource;

import java.util.EnumMap;
import java.util.Map;

public class Cost {
    private final EnumMap<Resource, Integer> costs;

    public Cost() {
        costs = new EnumMap<>(Resource.class);
    }

    public Cost add(Resource resource, Integer value) {
        costs.put(resource, value);
        return this;
    }

    public int get(Resource resource) {
        return costs.get(resource);
    }

    public Map<Resource, Integer> getAll() {
        return costs;
    }

    public String displayCost() {
        String txt = "";
        for(Resource resource : costs.keySet()) {
            txt += resource.getDisplayName() + ": ";
            txt += costs.get(resource) + " ";
        }
        return txt;
    }
}
