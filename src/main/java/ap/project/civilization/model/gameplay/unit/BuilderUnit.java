package ap.project.civilization.model.gameplay.unit;

import ap.project.civilization.model.gameplay.ui.MenuAction;
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
            }));
        }

        if(hex.getType() == HexType.MOUNTAIN && Technology.ironMine.isUnlocked()) {
            if(!((Terrain)hex).getInventory().contains(Resource.IRON)) return;
            if(builder.getAp() < BuildingType.IRON_MINE.getRequiredAP()) return;

            actions.add(new MenuAction("Build " + BuildingType.IRON_MINE.getDisplayName(), () -> {
                BuildingFactory.createIronMine((Terrain) hex);
                builder.resolveBuild(hex.getBuilding());
                FogOfWar.makeNeighborsVisible(unit.getCurrentHex());
            }));
        }

        boolean isEmpty = true;
        for(Resource r : Resource.values()) {
            if(((Terrain)hex).getInventory().contains(r)) isEmpty = false;
        }

        if(isEmpty) {
            if(builder.getAp() < BuildingType.TOWN.getRequiredAP()) return;

            actions.add(new MenuAction("Build Town", () -> {
                BuildingFactory.createTown((Terrain) hex);
                builder.resolveBuild(hex.getBuilding());
                FogOfWar.makeNeighborsVisible(unit.getCurrentHex());
                TownHall.getInstance().updateCapacity();
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

        if(hex.getType().getBuildingType() == BuildingType.STONE_MINE && !Technology.stoneMine.isUnlocked()) {
            return false;
        }
        return true;
    }

    @Override
    protected void addDetails(Unit unit, List<String> details) {
        details.add("charges left: " + ((Builder)unit).getCharges());
    }
}
