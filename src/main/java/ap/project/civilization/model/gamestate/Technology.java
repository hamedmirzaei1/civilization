package ap.project.civilization.model.gamestate;

public enum Technology {
    stoneMine,
    ironMine,
    premiumTool,
    townBuild,
    sailing;

    private boolean unlocked;

    Technology() {
        unlocked = false;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public void unLock() {
        unlocked = true;
    }
}
