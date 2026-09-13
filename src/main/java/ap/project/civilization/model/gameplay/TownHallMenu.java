package ap.project.civilization.model.gameplay;

import ap.project.civilization.model.gameplay.core.MenuAction;
import ap.project.civilization.model.gameplay.core.MenuModel;
import ap.project.civilization.model.gamestate.CentralTransaction;
import ap.project.civilization.model.gamestate.Cost;
import ap.project.civilization.model.gamestate.Technology;
import ap.project.civilization.model.util.CostConstants;
import ap.project.civilization.model.world.hex.hexes.TownHall;
import ap.project.civilization.model.world.resource.Warehouse;
import ap.project.civilization.model.world.unit.UnitManager;
import ap.project.civilization.model.world.unit.core.UnitFactory;
import ap.project.civilization.model.world.unit.core.UnitType;

import java.util.List;

public class TownHallMenu {
    private final UnitFactory unitFactory;

    private List<String> details;
    private List<MenuAction> actions;

    public TownHallMenu() {
        unitFactory = UnitManager.getInstance().getUnitFactory();
    }

    public MenuModel create(List<String> details, List<MenuAction> actions) {
        this.actions = actions;
        this.details = details;


        if(TownHall.getInstance().hasCapacity()) {
            for (UnitType type : UnitType.values()) {
                actions.add(new MenuAction("Create " + type.getDisplayName(), () -> {
                    unitFactory.addToQueue(type);
                }));
            }
        }

        addWareHouseUpgrades();
        addTechUpgrades();

        return new MenuModel(details, actions);
    }

    private void addTechUpgrades() {
        List<Technology> chain = List.of(
                Technology.stoneMine,
                Technology.ironMine,
                Technology.premiumTool,
                Technology.sailing);

        for (Technology tech : chain) {
            if (!tech.isUnlocked()) {
                addTechUpgrade(tech);
                break;
            }
        }

        if(!Technology.townBuild.isUnlocked()) {
            addTechUpgrade(Technology.townBuild);
        }
    }

    private void addTechUpgrade(Technology tech) {
        Cost cost = tech.getCost();
        details.add(tech.getDisplayName() + ":: " + cost.displayCost().trim());
        if(!CentralTransaction.getInstance().canAfford(cost)) return;
        actions.add(new MenuAction(tech.getDisplayName() + " Tech", () -> {
            CentralTransaction.getInstance().pay(cost);
            tech.unLock();
        }));
    }

    private void addWareHouseUpgrades() {
        Warehouse warehouse = TownHall.getInstance().getWarehouse();

        String nextLvl = "";
        if(warehouse.getLevel() == 0) {
            nextLvl = "I";
            details.add(nextLvl + " lvl warehouse:: " + CostConstants.upgradeTownHallWarehouse1.displayCost());
            if(warehouse.isUpgradable()) {
                actions.add(new MenuAction("Upgrade Warehouse " + nextLvl, () -> {
                    CentralTransaction.getInstance().pay(CostConstants.upgradeTownHallWarehouse1);
                    warehouse.upgrade();
                }));
            }
        }
        if(warehouse.getLevel() == 1) {
            nextLvl = "II";
            details.add(nextLvl + " lvl warehouse:: " + CostConstants.upgradeTownHallWarehouse2.displayCost());
            if(warehouse.isUpgradable()) {
                actions.add(new MenuAction("Upgrade Warehouse " + nextLvl, () -> {
                    CentralTransaction.getInstance().pay(CostConstants.upgradeTownHallWarehouse2);
                    warehouse.upgrade();
                }));
            }
        }

    }
}
