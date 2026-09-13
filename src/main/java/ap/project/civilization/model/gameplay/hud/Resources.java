package ap.project.civilization.model.gameplay.hud;

import ap.project.civilization.model.gameplay.core.MenuAction;
import ap.project.civilization.model.gameplay.core.MenuModel;
import ap.project.civilization.model.util.ModelConstants;
import ap.project.civilization.model.world.building.ProductionBuilding;
import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.hexes.TownHall;
import ap.project.civilization.model.world.resource.Resource;
import ap.project.civilization.model.world.resource.Warehouse;
import ap.project.civilization.model.world.unit.UnitManager;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.model.world.unit.core.UnitType;
import ap.project.civilization.view.util.ui.UIColors;

import java.awt.Color;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Resources {
    public static MenuModel create() {
        List<String> details = new ArrayList<>();
        List<MenuAction> actions = new ArrayList<>();
        List<Color> colors = new ArrayList<>();

        Warehouse warehouse = TownHall.getInstance().getWarehouse();

        Map<Resource, Integer> netRate = new EnumMap<>(Resource.class);
        for(Resource resource : Resource.values()) {
            netRate.put(resource, 0);
        }

        for(Hex hex : HexManager.getInstance().getHexes()) {
            if(!hex.isUnlock()) continue;
            if(!hex.hasBuilding()) continue;
            if(!(hex.getBuilding() instanceof ProductionBuilding)) continue;
            ProductionBuilding productionBuilding = (ProductionBuilding) hex.getBuilding();
            if(productionBuilding.getWorkerNumbers() == 0) continue;
            netRate.merge(productionBuilding.getType().getResource(),
                    productionBuilding.getProductionPerTurn(), Integer::sum);
        }
        netRate.merge(Resource.FOOD,
                -(UnitManager.getInstance().getUnits().size() * ModelConstants.FOOD_CONSUME_PER_UNIT),
                Integer::sum);

        for(Resource resource : Resource.values()) {
            int rate = netRate.get(resource);
            String sign = rate >= 0 ? "+" : "";
            details.add(resource.getDisplayName() + ": " + warehouse.get(resource) +
                    " of  " + warehouse.getCapacity() + "  " + sign + rate);
            colors.add(rate >= 0 ? UIColors.RATE_POSITIVE : UIColors.RATE_NEGATIVE);
        }

        details.add("Units: " + TownHall.getInstance().getUnitNumbers() + " of  " + TownHall.getInstance().getUnitCapacity());
        int workers = 0;
        int builders = 0;
        int explorers = 0;
        int bExpanders = 0;
        for(Unit unit : UnitManager.getInstance().getUnits()) {
            if(unit.getType() == UnitType.WORKER) workers++;
            if(unit.getType() == UnitType.BUILDER) builders++;
            if(unit.getType() == UnitType.EXPLORER) explorers++;
            if(unit.getType() == UnitType.BORDER_EXPANDER) bExpanders++;
        }
        details.add("Workers: " + workers);
        details.add("Builders: " + builders);
        details.add("Explorers: " + explorers);
        details.add("Border Expanders: " + bExpanders);
        return new MenuModel(details, actions, colors);
    }
}
