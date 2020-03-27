package com.github.martinfrank.javarouge.model;

import com.github.martinfrank.javarouge.model.map.RougeMap;
import com.github.martinfrank.javarouge.save.SaveGame;
import com.github.martinfrank.javarouge.view.ProgressMonitor;

public class RougeGame {

    private RougeMap currentMap;
    private Player player;

    public void loadSaveGame(SaveGame saveGame, ProgressMonitor monitor) {
        this.currentMap = saveGame.getCurrentMap();
        this.player = saveGame.getPlayer();
    }
}
