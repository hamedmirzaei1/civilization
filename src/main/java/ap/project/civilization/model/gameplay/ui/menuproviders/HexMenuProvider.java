package ap.project.civilization.model.gameplay.ui.menuproviders;

import ap.project.civilization.model.gameplay.ui.MenuAction;
import ap.project.civilization.model.gameplay.ui.MenuModel;
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

        if(hex.isVisible()) {

            details.add(hex.getType().getDisplayName());

            if(hex.hasBuilding() && hex.getType() != HexType.TOWN_HALL) {
                details.add("with " + hex.getBuilding().getType().getDisplayName());
            }

            String resourceText = "";
            boolean firstTime = true;
            for (Resource r : hex.getType().getResources()) {
                if (!firstTime) resourceText += "   ";
                resourceText += r.getDisplayName() + ": " + ((Terrain) hex).getInventory().get(r);
                firstTime = false;
            }
            if (!resourceText.isEmpty()) details.add(resourceText);

        } else {
            details.add("Unknown");
        }

        List<MenuAction> actions = new ArrayList<>();
        actions.add(new MenuAction("close", () -> {
        }));

        return new MenuModel(details, actions);
    }
}
