package ap.project.civilization.model.ui;

import ap.project.civilization.model.world.hex.Hex;
import ap.project.civilization.model.world.terrain.Terrain;

import java.util.ArrayList;
import java.util.List;

public class HexMenuProvider implements MenuProvider<Hex> {

    @Override
    public MenuModel createMenu(Hex hex) {
        List<String> details = new ArrayList<>();
        details.add(((Terrain)hex).getTerrainType().name());

        List<MenuAction> actions = new ArrayList<>();
        actions.add(new MenuAction("close", () -> {
        }));

        return new MenuModel(details, actions);
    }
}
