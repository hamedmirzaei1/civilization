# AGENTS.md

## Project

Civilization-style game — Java 25, single-package Maven project (`ap.project.civilization`). No external dependencies.

## Build & verify

- `mvn compile` (Maven not installed on this machine). Compile directly: `find src/main/java -name "*.java" > /tmp/sources.txt && javac -d /tmp/out @/tmp/sources.txt`
- No test framework. Smoke-test domain logic by writing a temp Java class with `HexManager.resetSingleton()` via reflection, then verify reachability and cluster properties manually.

## Architecture

- **Entry point:** `Main.java` → `GameFrame` (Swing) → `GamePanel` → `GameController` / `GameLoop`
- **Model singleton:** `HexManager.getInstance()` owns all hex data. Constructed once at startup. Reset via reflection for smoke tests: set `instance` field to `null`.
- **TownHall** is always at center `(WORLD_SIZE/2, WORLD_SIZE/2)` = `(25, 25)`. Placed last by `HexFactory.setTownHall()`.

## Hex grid

- Offset coordinates `(q, r)`, q = column, r = row. Neighbors via `Direction` enum (6 dirs: UP_LEFT, UP_RIGHT, LEFT, RIGHT, DOWN_LEFT, DOWN_RIGHT).
- `HexType` enum: FOREST, PLAIN, MOUNTAIN, ROCK_MOUNTAIN (impassable), LAWN, SEA (impassable), TOWN_HALL.
- `HexType.getMoveCost()` — SEA and ROCK_MOUNTAIN return `-1` (impassable). Check `moveCost >= 0` for passability.

## Terrain spawning (`TerrainSpawn.createTerrain`)

Three-phase algorithm in `model/world/hex/core/TerrainSpawn.java`:

1. **Seeds:** Random SEA (8 seeds, capped at 60 each) and ROCK_MOUNTAIN (5 seeds, capped at 40 each) placed away from border keep-out (2-cell ring) and townhall protected zone.
2. **Spread:** Clusters grow via **densest-first** selection (each iteration picks the empty cell with the most same-type neighbors). Growth stops when the cluster is surrounded or hits its cap.
3. **Fill:** Remaining cells get equal-random passable types `{FOREST, PLAIN, MOUNTAIN, LAWN}`.

Constraints enforced:
- SEA and ROCK_MOUNTAIN never adjacent (cross-type adjacency banned)
- No impassable hex within 6-neighbors of townhall position
- No impassable hex in border keep-out ring (prevents spanning barrier)
- Each blob capped at `SEA_MAX_BLOB_SIZE` / `ROCK_MOUNTAIN_MAX_BLOB_SIZE`

Constants in `ModelConstants.java`: `WORLD_SIZE=50`, `SEA_SEED_COUNT=8`, `ROCK_MOUNTAIN_SEED_COUNT=5`, `SEA_MAX_BLOB_SIZE=60`, `ROCK_MOUNTAIN_MAX_BLOB_SIZE=40`, `MAP_BORDER_KEEP_OUT=2`.

## Gotchas

- `HexFactory.createTerrain(TOWN_HALL, q, r)` is a no-op — always place townhall via `hexFactory.setTownHall()`.
- `HexManager.pixelCoords` is only computed at construction. Adding hexes after init requires recomputing.
- `MarginHex` map in `HexManager` is never initialized (`marginHexes` field). `putMarginHex` will NPE — unused code path.
