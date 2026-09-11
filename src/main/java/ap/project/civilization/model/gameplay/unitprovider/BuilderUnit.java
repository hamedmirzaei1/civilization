package ap.project.civilization.model.gameplay.unitprovider;

import ap.project.civilization.model.gameplay.core.MenuAction;
import ap.project.civilization.model.gamestate.Consumer;
import ap.project.civilization.model.gamestate.Cost;
import ap.project.civilization.model.gamestate.Technology;
import ap.project.civilization.model.world.building.BuildingFactory;
import ap.project.civilization.model.world.building.BuildingType;
import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.hexes.HexType;
import ap.project.civilization.model.world.hex.hexes.Terrain;
import ap.project.civilization.model.world.hex.hexes.TownHall;
import ap.project.civilization.model.world.resource.Resource;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.model.world.unit.movement.FogOfWar;
import ap.project.civilization.model.world.unit.units.Builder;

import java.util.List;

public class BuilderUnit extends GeneralUnit {
    @Override
    protected void addActions(Unit unit, List<MenuAction> actions) {
        Hex hex = unit.getCurrentHex();
        Builder builder = (Builder) unit;

        if(!canBuild(hex)) return;

        if(canBuildGeneral(builder, hex)) {

            actions.add(new MenuAction("Build " + hex.getType().getBuildingType().getDisplayName(), () -> {
                BuildingFactory.createProductionBuilding((Terrain) hex);
                builder.resolveBuild(hex.getBuilding());
                FogOfWar.makeNeighborsVisible(unit.getCurrentHex());
                Consumer.consume(hex.getBuilding().getType().getRequiredResource());
            }));
        }

        if(hex.getType() == HexType.MOUNTAIN && Technology.ironMine.isUnlocked()) {
            if(!((Terrain)hex).getInventory().contains(Resource.IRON)) return;
            if(builder.getAp() < BuildingType.IRON_MINE.getRequiredAP()) return;
            if(!Consumer.canConsume(BuildingType.IRON_MINE.getRequiredResource())) return;

            actions.add(new MenuAction("Build " + BuildingType.IRON_MINE.getDisplayName(), () -> {
                BuildingFactory.createIronMine((Terrain) hex);
                builder.resolveBuild(hex.getBuilding());
                FogOfWar.makeNeighborsVisible(unit.getCurrentHex());
                Consumer.consume(BuildingType.IRON_MINE.getRequiredResource());
            }));
        }

        boolean isEmpty = true;
        for(Resource r : Resource.values()) {
            if(((Terrain)hex).getInventory().contains(r)) isEmpty = false;
        }

        if(isEmpty) {
            if(builder.getAp() < BuildingType.TOWN.getRequiredAP()) return;
            if(!Consumer.canConsume(BuildingType.TOWN.getRequiredResource())) return;


            actions.add(new MenuAction("Build Town", () -> {
                BuildingFactory.createTown((Terrain) hex);
                builder.resolveBuild(hex.getBuilding());
                FogOfWar.makeNeighborsVisible(unit.getCurrentHex());
                TownHall.getInstance().updateCapacity();
                Consumer.consume(BuildingType.TOWN.getRequiredResource());
            }));
        }

    }

    private boolean canBuild(Hex hex) {
        if(!hex.isUnlock()) return false;
        if(hex.hasBuilding()) return false;
        return true;
    }

    private boolean canBuildGeneral(Builder builder, Hex hex) {
        if(builder.getAp() < hex.getType().getBuildingType().getRequiredAP()) return false;
        if(!((Terrain)hex).getInventory().contains(hex.getType().getBuildingType().getResource())) return false;
        if(!Consumer.canConsume(hex.getType().getBuildingType().getRequiredResource())) return false;

        if(hex.getType().getBuildingType() == BuildingType.STONE_MINE && !Technology.stoneMine.isUnlocked()) {
            return false;
        }
        return true;
    }

    @Override
    protected void addDetails(Unit unit, List<String> details) {
        details.add("charges left: " + ((Builder)unit).getCharges());

        Hex hex = unit.getCurrentHex();
        if(!canBuild(hex)) return;

        BuildingType type = hex.getType().getBuildingType();
        if(type != null) {
            addConstructionCost(type, details);
        }

        if(hex.getType() == HexType.MOUNTAIN) {
            addConstructionCost(BuildingType.IRON_MINE, details);
        }

        if(isEmpty(hex)) {
            addConstructionCost(BuildingType.TOWN, details);
        }
    }

    private void addConstructionCost(BuildingType type, List<String> details) {
        Cost cost = new Cost();
        for(Resource r : type.getRequiredResource()) {
            cost.add(r, Consumer.getConsumingRate());
        }
        if(cost.getAll().isEmpty()) return;
        details.add(type.getDisplayName() + " cost: " + cost.displayCost().trim());
    }

    private boolean isEmpty(Hex hex) {
        for(Resource r : Resource.values()) {
            if(((Terrain)hex).getInventory().contains(r)) return false;
        }
        return true;
    }
}
