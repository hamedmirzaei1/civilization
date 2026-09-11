package ap.project.civilization.model.gamestate;


import ap.project.civilization.model.world.resource.Resource;

import java.util.Set;

public class Consumer {
    private static final int consumingRate = 5;

    public static int getConsumingRate() {
        return consumingRate;
    }

    public static void consume(Set<Resource> resources) {
        CentralTransaction transaction = CentralTransaction.getInstance();
        for (Resource r : resources) {
            transaction.pay(new Cost().add(r, consumingRate));
        }
    }
    public static boolean canConsume(Set<Resource> resource) {
        Cost cost = new Cost();
        for (Resource r : resource) {
            cost.add(r, consumingRate);
        }
        return CentralTransaction.getInstance().canAfford(cost);
    }
}
