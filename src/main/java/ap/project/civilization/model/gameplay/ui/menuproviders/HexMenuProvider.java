package ap.project.civilization.model.gameplay.ui.menuproviders;

import ap.project.civilization.model.gameplay.ui.MenuAction;
import ap.project.civilization.model.gameplay.ui.MenuModel;
import ap.project.civilization.model.world.building.ProductionBuilding;
import ap.project.civilization.model.world.hex.core.Hex;
import ap.project.civilization.model.world.hex.hexes.HexType;
import ap.project.civilization.model.world.hex.hexes.Terrain;
import ap.project.civilization.model.world.resource.Resource;

import java.util.ArrayList;
import java.util.List;

public class HexMenuProvider implements MenuProvider<Hex> {

    @Override
    public MenuModel createMenu(Hex hex) {
        List<String> details = new ArrayList<>();
        List<MenuAction> actions = new ArrayList<>();

        if(hex.isVisible()) {

            details.add(hex.getType().getDisplayName());

            if(hex.hasBuilding() && hex.getType() != HexType.TOWN_HALL) {
                ProductionBuilding building = (ProductionBuilding) hex.getBuilding();
                details.add("with " + hex.getBuilding().getType().getDisplayName());
                details.add("workers  " + building.getWorkerNumbers() + " of  "  + building.getCapacity());
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
                details.add(" you can build " + hex.getType().getBuildingType().getDisplayName());
                details.add(hex.getType().getBuildingType().getRequiredAP() + " ap");
            }

        } else {
            details.add("Unknown");
        }



        return new MenuModel(details, actions);
    }
}
