package com.github.martinfrank.javarouge.model.rules;

import com.github.martinfrank.javarouge.model.Player;
import com.github.martinfrank.javarouge.model.maze.Terrain;

public class WalkCostRules {

    public static double getEnteringTerrainCosts(Terrain terrain, Player player) {
        return 1.45567;
    }
}
