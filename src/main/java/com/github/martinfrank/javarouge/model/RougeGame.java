package com.github.martinfrank.javarouge.model;

import com.github.martinfrank.javarouge.model.map.RougeMap;
import com.github.martinfrank.javarouge.save.SaveGame;
import com.github.martinfrank.javarouge.view.ProgressMonitor;
import com.github.martinfrank.maplib.Direction;

public class RougeGame {

    private RougeMap currentMap;
    private Player player;
    private double turnTime;

    public void setCurrentMap(RougeMap currentMap) {
        this.currentMap = currentMap;
    }

    public void loadSaveGame(SaveGame saveGame, ProgressMonitor monitor) {
        this.currentMap = saveGame.getCurrentMap();
        this.player = saveGame.getPlayer();
    }

    public RougeMap getMap() {
        return currentMap;
    }

    public void movePlayer(Direction dir) {
//        RougeMapField target = currentMap.getTarget(player, dir);
//        double walkCost = WalkCostRules.getEnteringTerrainCosts(target.getData().getTerrain(), player);
        double walkCost = 1.45567;
        turnTime(walkCost);
    }

    private void turnTime(double turnTime) {
        this.turnTime = this.turnTime + turnTime;
        currentMap.turnTime(turnTime, player);
    }

}
