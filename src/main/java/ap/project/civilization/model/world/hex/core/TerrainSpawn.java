package ap.project.civilization.model.world.hex.core;

import ap.project.civilization.model.util.ModelConstants;
import ap.project.civilization.model.world.hex.HexManager;
import ap.project.civilization.model.world.hex.hexes.HexType;
import ap.project.civilization.model.world.hex.hexes.TownHall;
import ap.project.civilization.model.world.unit.movement.Direction;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static ap.project.civilization.model.world.hex.hexes.HexType.FOREST;
import static ap.project.civilization.model.world.hex.hexes.HexType.LAWN;
import static ap.project.civilization.model.world.hex.hexes.HexType.MOUNTAIN;
import static ap.project.civilization.model.world.hex.hexes.HexType.PLAIN;
import static ap.project.civilization.model.world.hex.hexes.HexType.ROCK_MOUNTAIN;
import static ap.project.civilization.model.world.hex.hexes.HexType.SEA;

public class TerrainSpawn {
    private final HexFactory hexFactory;
    private final HexManager hexManager;

    private final Set<HexCoord> protectedPositions = new HashSet<>();
    private final Set<HexCoord> borderPositions = new HashSet<>();
    private final Map<HexCoord, Integer> clusterIds = new HashMap<>();
    private final int[] clusterSizes = new int[ModelConstants.SEA_SEED_COUNT + ModelConstants.ROCK_MOUNTAIN_SEED_COUNT];

    private int townQ;
    private int townR;

    public TerrainSpawn(HexManager hexManager) {
        this.hexManager = hexManager;
        hexFactory = new HexFactory(hexManager);
    }

    public void createTerrain(int number) {
        TownHall townHall = TownHall.getInstance();
        townQ = townHall.getQ();
        townR = townHall.getR();

        computeProtectedPositions(number);
        computeBorderPositions(number);

        placeSeeds(number, SEA, ModelConstants.SEA_SEED_COUNT, ModelConstants.SEA_MAX_BLOB_SIZE);
        placeSeeds(number, ROCK_MOUNTAIN, ModelConstants.ROCK_MOUNTAIN_SEED_COUNT, ModelConstants.ROCK_MOUNTAIN_MAX_BLOB_SIZE);

        spreadClusters(number, SEA, ModelConstants.SEA_MAX_BLOB_SIZE);
        spreadClusters(number, ROCK_MOUNTAIN, ModelConstants.ROCK_MOUNTAIN_MAX_BLOB_SIZE);

        HexType[] passable = {FOREST, PLAIN, MOUNTAIN, LAWN};
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if (i == townQ && j == townR) continue;
                if (hexManager.getHex(i, j) != null) continue;

                hexFactory.createTerrain(passable[ThreadLocalRandom.current().nextInt(passable.length)], i, j);
            }
        }

        hexFactory.setTownHall();
        verifyReachability(number);
    }

    private void computeProtectedPositions(int number) {
        addIfInBounds(protectedPositions, townQ, townR, number);
        for (Direction direction : Direction.values()) {
            addIfInBounds(protectedPositions, townQ + direction.getDq(), townR + direction.getDr(), number);
        }
    }

    private void computeBorderPositions(int number) {
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if (i < ModelConstants.MAP_BORDER_KEEP_OUT || j < ModelConstants.MAP_BORDER_KEEP_OUT
                        || i >= number - ModelConstants.MAP_BORDER_KEEP_OUT || j >= number - ModelConstants.MAP_BORDER_KEEP_OUT) {
                    borderPositions.add(new HexCoord(i, j));
                }
            }
        }
    }

    private static void addIfInBounds(Set<HexCoord> target, int q, int r, int size) {
        if (q < 0 || r < 0 || q >= size || r >= size) return;
        target.add(new HexCoord(q, r));
    }

    private void placeSeeds(int number, HexType type, int seedCount, int maxSize) {
        int placed = 0;
        int attempts = 0;
        while (placed < seedCount && attempts < seedCount * number * number) {
            attempts++;
            int q = ThreadLocalRandom.current().nextInt(number);
            int r = ThreadLocalRandom.current().nextInt(number);
            if (!canPlaceImpassable(q, r, type)) continue;

            createCluster(type, q, r);
            placed++;
        }
    }

    private boolean canPlaceImpassable(int q, int r, HexType type) {
        HexCoord coordinate = new HexCoord(q, r);
        if (protectedPositions.contains(coordinate)) return false;
        if (borderPositions.contains(coordinate)) return false;
        if (hexManager.getHex(q, r) != null) return false;
        return !isAdjacentToHazard(q, r, opposite(type));
    }

    private void createCluster(HexType type, int q, int r) {
        hexFactory.createTerrain(type, q, r);
        int id = nextClusterId();
        clusterIds.put(new HexCoord(q, r), id);
        clusterSizes[id] = 1;
    }

    private int nextClusterId() {
        for (int i = 0; i < clusterSizes.length; i++) {
            if (clusterSizes[i] == 0) return i;
        }
        return clusterSizes.length - 1;
    }

    private void spreadClusters(int number, HexType type, int maxSize) {
        boolean progressed = true;
        while (progressed) {
            progressed = false;

            int bestScore = 0;
            int bestQ = -1;
            int bestR = -1;
            for (int i = 0; i < number; i++) {
                for (int j = 0; j < number; j++) {
                    if (hexManager.getHex(i, j) != null) continue;
                    if (!canGrow(i, j, type, maxSize)) continue;

                    int score = sameTypeNeighborCount(i, j, type);
                    if (score > bestScore) {
                        bestScore = score;
                        bestQ = i;
                        bestR = j;
                    }
                }
            }

            if (bestQ != -1) {
                growCluster(bestQ, bestR, type);
                progressed = true;
            }
        }
    }

    private int sameTypeNeighborCount(int q, int r, HexType type) {
        int count = 0;
        for (Direction direction : Direction.values()) {
            Hex neighbor = hexManager.getHex(q + direction.getDq(), r + direction.getDr());
            if (neighbor != null && neighbor.getType() == type) count++;
        }
        return count;
    }

    private boolean canGrow(int q, int r, HexType type, int maxSize) {
        HexCoord coordinate = new HexCoord(q, r);
        if (protectedPositions.contains(coordinate)) return false;
        if (borderPositions.contains(coordinate)) return false;
        if (isAdjacentToHazard(q, r, opposite(type))) return false;

        int mergedSize = adjacentClusterSize(q, r, type);
        if (mergedSize == 0) return false;
        return mergedSize + 1 <= maxSize;
    }

    private void growCluster(int q, int r, HexType type) {
        Set<Integer> ids = adjacentClusterIds(q, r, type);

        int target = -1;
        int targetSize = -1;
        int mergedSize = 0;
        for (int id : ids) {
            mergedSize += clusterSizes[id];
            if (clusterSizes[id] > targetSize) {
                targetSize = clusterSizes[id];
                target = id;
            }
        }

        hexFactory.createTerrain(type, q, r);
        clusterIds.put(new HexCoord(q, r), target);
        clusterSizes[target] = mergedSize + 1;

        for (int id : ids) {
            if (id == target) continue;
            relabelCluster(id, target);
            clusterSizes[id] = 0;
        }
    }

    private void relabelCluster(int from, int to) {
        for (Map.Entry<HexCoord, Integer> entry : clusterIds.entrySet()) {
            if (entry.getValue() == from) entry.setValue(to);
        }
    }

    private int adjacentClusterSize(int q, int r, HexType type) {
        Set<Integer> ids = adjacentClusterIds(q, r, type);
        int size = 0;
        for (int id : ids) size += clusterSizes[id];
        return size;
    }

    private Set<Integer> adjacentClusterIds(int q, int r, HexType type) {
        Set<Integer> ids = new HashSet<>();
        for (Direction direction : Direction.values()) {
            Hex neighbor = hexManager.getHex(q + direction.getDq(), r + direction.getDr());
            if (neighbor == null || neighbor.getType() != type) continue;

            Integer id = clusterIds.get(new HexCoord(neighbor.getQ(), neighbor.getR()));
            if (id != null) ids.add(id);
        }
        return ids;
    }

    private boolean isAdjacentToHazard(int q, int r, HexType hazard) {
        if (hazard == null) return false;
        for (Direction direction : Direction.values()) {
            Hex neighbor = hexManager.getHex(q + direction.getDq(), r + direction.getDr());
            if (neighbor != null && neighbor.getType() == hazard) return true;
        }
        return false;
    }

    private static HexType opposite(HexType type) {
        if (type == SEA) return ROCK_MOUNTAIN;
        if (type == ROCK_MOUNTAIN) return SEA;
        return null;
    }

    private void verifyReachability(int number) {
        Set<HexCoord> reachable = new HashSet<>();
        Queue<HexCoord> queue = new ArrayDeque<>();
        reachable.add(new HexCoord(townQ, townR));
        queue.add(new HexCoord(townQ, townR));

        while (!queue.isEmpty()) {
            HexCoord current = queue.poll();
            for (Direction direction : Direction.values()) {
                int nq = current.getQ() + direction.getDq();
                int nr = current.getR() + direction.getDr();
                HexCoord neighborCoord = new HexCoord(nq, nr);
                if (reachable.contains(neighborCoord)) continue;

                Hex neighbor = hexManager.getHex(nq, nr);
                if (neighbor == null || !isPassable(neighbor)) continue;

                reachable.add(neighborCoord);
                queue.add(neighborCoord);
            }
        }

        int passableTotal = 0;
        for (Hex hex : hexManager.getHexes()) {
            if (isPassable(hex)) passableTotal++;
        }

        if (reachable.size() != passableTotal) {
            System.err.println("Warning: " + (passableTotal - reachable.size()) + " passable hexes are unreachable from the townhall.");
        }
    }

    private static boolean isPassable(Hex hex) {
        return hex.getType().getMoveCost() >= 0;
    }
}