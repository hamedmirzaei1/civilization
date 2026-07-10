package ap.project.civilization.model.world.hex.core;

import ap.project.civilization.model.world.building.Building;
import ap.project.civilization.model.world.hex.hexes.HexType;

public abstract class Hex {
    private final HexCoord coordinate;
    private boolean visible;
    private boolean unlock;
    private boolean selected;
    private boolean movable;

    private final HexType type;
    private Building building;

    public Hex(HexCoord coordinate, HexType type) {
        this.coordinate = coordinate;
        this.type = type;

        visible = false;
        unlock = false;
        selected = false;
        movable = false;
    }

    public int getQ() {
        return coordinate.getQ();
    }
    public int getR() {
        return coordinate.getR();
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean isUnlock() {
        return unlock;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setUnlock(boolean unlock) {
        this.unlock = unlock;
    }

    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isMovable() {
        return movable;
    }
    public void setMovable(boolean movable) {
        this.movable = movable;
    }

    public HexType getType() {
        return type;
    }

    public Building getBuilding() {
        if(building == null) throw new IllegalStateException("No building is constructed for this terrain");
        return building;
    }
    public boolean hasBuilding() {
        return building != null;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}