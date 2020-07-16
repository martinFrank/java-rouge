package com.github.martinfrank.javarouge.save;

import com.github.martinfrank.javarouge.model.Player;
import com.github.martinfrank.javarouge.model.entity.Entity;
import com.github.martinfrank.javarouge.model.entity.Item;
import com.github.martinfrank.javarouge.model.map.MapUtils;
import com.github.martinfrank.javarouge.model.map.RougeMap;
import com.github.martinfrank.javarouge.model.map.RougeMapUtil;
import com.github.martinfrank.javarouge.model.maze.MazeGeneratorUtil;
import com.github.martinfrank.javarouge.objects.ObjectsManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaveGame {

    private static final Logger LOGGER = LoggerFactory.getLogger(SaveGame.class);

    private final Player player;
    private RougeMap currentMap;

    public SaveGame(Player player, ObjectsManager objectsManager) {
        this.player = player;
        currentMap = MapUtils.createMap(31, 31);
        MazeGeneratorUtil.generateMaze(currentMap);

        RougeMapUtil.getRandomAccessablePosition(currentMap).
                getData().getItems().add(new Item(objectsManager.getItem("Steel dagger")));
        RougeMapUtil.getRandomAccessablePosition(currentMap).
                getData().getEntities().add(new Entity(objectsManager.getMonster("Goblin")));

        player.setPosition(RougeMapUtil.getRandomAccessablePosition(currentMap));
    }

    public Player getPlayer() {
        return player;
    }

    public RougeMap getCurrentMap() {
        return currentMap;
    }

}
