package ap.project.civilization.model.gameplay;

import ap.project.civilization.model.gameplay.core.MenuAction;
import ap.project.civilization.model.gameplay.core.MenuModel;
import ap.project.civilization.model.gameplay.core.MenuProvider;
import ap.project.civilization.model.world.building.ProductionBuilding;
import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.hexes.HexType;
import ap.project.civilization.model.world.hex.hexes.Terrain;
import ap.project.civilization.model.world.resource.Resource;

import java.util.ArrayList;
import java.util.List;

public class HexMenuProvider implements MenuProvider<Hex> {
    private TownHallMenu townHallMenu = new TownHallMenu();

    @Override
    public MenuModel createMenu(Hex hex) {
        List<String> details = new ArrayList<>();
        List<MenuAction> actions = new ArrayList<>();

        if(hex.isVisible()) {

            details.add(hex.getType().getDisplayName());

            if(hex.getType() == HexType.TOWN_HALL) {
                return townHallMenu.create(details, actions);
            }

            if(hex.hasBuilding() && hex.getType() != HexType.TOWN_HALL) {
                ProductionBuilding building = (ProductionBuilding) hex.getBuilding();
                details.add("with " + building.getType().getDisplayName());
                details.add("workers  " + building.getWorkerNumbers() + " of  "  + building.getCapacity());
                details.add("producing " + building.getProductionPerTurn() + " " +
                        building.getType().getResource().getDisplayName() + " per turn");
                details.add("");
            }


            String resourceText = "";
            boolean firstTime = true;
            for (Resource r : hex.getType().getResources()) {
                if (!firstTime) resourceText += "   ";
                resourceText += r.getDisplayName() + ": " + ((Terrain) hex).getInventory().get(r);
                firstTime = false;
            }
            if (!resourceText.isEmpty()) details.add(resourceText);

            if(!hex.hasBuilding()){
            }

        } else {
            details.add("Unknown");
        }



        return new MenuModel(details, actions);
    }
}
