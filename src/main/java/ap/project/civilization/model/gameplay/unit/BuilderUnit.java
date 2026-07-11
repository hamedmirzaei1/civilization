package ap.project.civilization.model.gameplay.unit;

import ap.project.civilization.model.gameplay.ui.MenuAction;
import ap.project.civilization.model.world.building.BuildingFactory;
import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.hexes.Terrain;
import ap.project.civilization.model.world.unit.core.Unit;
import ap.project.civilization.model.world.unit.movement.FogOfWar;
import ap.project.civilization.model.world.unit.units.Builder;

import java.util.List;

public class BuilderUnit extends GeneralUnit {
    @Override
    protected void addActions(Unit unit, List<MenuAction> actions) {
        Hex hex = unit.getCurrentHex();
        Builder builder = (Builder) unit;

        if(!canBuild(builder, hex)) return;

        Runnable build = new Runnable() {
            @Override
            public void run() {
                BuildingFactory.createProductionBuilding((Terrain) hex);
                builder.resolveBuild(hex.getBuilding());
                FogOfWar.makeNeighborsVisible(unit.getCurrentHex());
            }
        };

        actions.add(new MenuAction("Build " + hex.getType().getBuildingType().getDisplayName(), build));
    }

    private boolean canBuild(Builder builder, Hex hex) {
        if(!hex.isUnlock()) return false;
        if(hex.hasBuilding()) return false;
        if(builder.getAp() < hex.getType().getBuildingType().getRequiredAP()) return false;

        return true;
    }

    @Override
    protected void addDetails(Unit unit, List<String> details) {
        details.add("charges left: " + ((Builder)unit).getCharges());
    }
}
