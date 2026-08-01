package ap.project.civilization.model.gameplay;

import ap.project.civilization.model.gameplay.core.MenuAction;
import ap.project.civilization.model.gameplay.core.MenuModel;
import ap.project.civilization.model.gamestate.Technology;
import ap.project.civilization.model.world.hex.hexes.TownHall;
import ap.project.civilization.model.world.resource.Warehouse;
import ap.project.civilization.model.world.unit.UnitManager;
import ap.project.civilization.model.world.unit.core.UnitFactory;
import ap.project.civilization.model.world.unit.core.UnitType;

import java.util.List;

public class TownHallMenu {
    private final UnitFactory unitFactory;

    public TownHallMenu() {
        unitFactory = UnitManager.getInstance().getUnitFactory();
    }

    public MenuModel create(List<String> details, List<MenuAction> actions) {
        Warehouse warehouse = TownHall.getInstance().getWarehouse();

        if(TownHall.getInstance().hasCapacity()) {
            for (UnitType type : UnitType.values()) {
                actions.add(new MenuAction("Create " + type.getDisplayName(), () -> {
                    unitFactory.addToQueue(type);
                }));
            }
        }

        if(warehouse.isUpgradable()) {
            String nextLvl = "";
            if(warehouse.getLevel() == 0) nextLvl = "I";
            if(warehouse.getLevel() == 1) nextLvl = "II";
            actions.add(new MenuAction("Upgrade Warehouse " + nextLvl, warehouse::upgrade));
        }

        if(!Technology.stoneMine.isUnlocked()) {
            actions.add(new MenuAction("Stone Mine Tech", Technology.stoneMine::unLock));
        } else if (!Technology.ironMine.isUnlocked()) {
            actions.add(new MenuAction("Iron Mine Tech", Technology.ironMine::unLock));
        } else if(!Technology.premiumTool.isUnlocked()) {
            actions.add(new MenuAction("Premium Tool Tech", Technology.premiumTool::unLock));
        }
        if(!Technology.townBuild.isUnlocked()) {
            actions.add(new MenuAction("Build Town Tech", Technology.townBuild::unLock));
        }

        return new MenuModel(details, actions);
    }
}
