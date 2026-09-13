package ap.project.civilization.model.gamestate;

import ap.project.civilization.model.world.resource.Resource;

public enum Technology {
    stoneMine("Stone Mine", new Cost().add(Resource.WOOD, 10)),
    ironMine("Iron Mine", new Cost().add(Resource.WOOD, 20).add(Resource.STONE, 10)),
    premiumTool("Premium Tool", new Cost().add(Resource.WOOD, 20).add(Resource.STONE, 20)),
    townBuild("Build Town", new Cost().add(Resource.WOOD, 40).add(Resource.STONE, 30).add(Resource.IRON, 20)),
    sailing("Sailing", new Cost().add(Resource.WOOD, 40).add(Resource.STONE, 20));

    private final String displayName;
    private final Cost cost;

    private boolean unlocked;

    Technology(String displayName, Cost cost) {
        this.displayName = displayName;
        this.cost = cost;
        unlocked = false;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Cost getCost() {
        return cost;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public void unLock() {
        unlocked = true;
    }
}