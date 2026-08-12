package ap.project.civilization.model.util;

import ap.project.civilization.model.gamestate.Cost;
import ap.project.civilization.model.world.resource.Resource;

public final class CostConstants {
    public static final Cost upgradeTownHallWarehouse1 = new Cost()
            .add(Resource.WOOD, 20).add(Resource.STONE, 10);

    public static final Cost upgradeTownHallWarehouse2 = new Cost()
            .add(Resource.WOOD, 40).add(Resource.STONE, 20);
}
