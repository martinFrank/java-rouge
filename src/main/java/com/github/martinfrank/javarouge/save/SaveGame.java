package com.github.martinfrank.javarouge.save;

import com.github.martinfrank.javarouge.model.Player;
import com.github.martinfrank.javarouge.model.map.MapUtils;
import com.github.martinfrank.javarouge.model.map.RougeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaveGame {

    private static final Logger LOGGER = LoggerFactory.getLogger(SaveGame.class);

    private final Player player;
    private RougeMap currentMap;

    public SaveGame(Player player) {
        this.player = player;
        currentMap = MapUtils.createMap(32, 32);
    }

    public Player getPlayer() {
        return player;
    }

    public RougeMap getCurrentMap() {
        return currentMap;
    }

}
