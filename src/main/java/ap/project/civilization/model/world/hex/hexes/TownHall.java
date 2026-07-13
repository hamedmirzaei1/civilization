package ap.project.civilization.model.world.hex.hexes;

import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.core.HexCoord;
import ap.project.civilization.model.util.ModelConstants;
import ap.project.civilization.model.world.resource.Warehouse;

public class TownHall extends Hex {
    private static TownHall instance;

    private int unitCapacity = 50;

    public static TownHall getInstance() {
        if(instance == null) {
            instance = new TownHall();
        }
        return instance;
    }

    private final Warehouse warehouse;

    public TownHall() {
        super(new HexCoord(ModelConstants.WORLD_SIZE/2, ModelConstants.WORLD_SIZE/2), HexType.TOWN_HALL);
        setUnlock(true);
        setVisible(true);

        warehouse = new Warehouse(ModelConstants.TOWN_HALL_WAREHOUSE_CAP);
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public int getUnitCapacity() {
        return unitCapacity;
    }

    public void addUnit() {
        unitCapacity++;
    }
}
