package com.github.martinfrank.javarouge.save;

import com.github.martinfrank.javarouge.model.Player;
import com.github.martinfrank.javarouge.model.entity.Entity;
import com.github.martinfrank.javarouge.model.entity.Item;
import com.github.martinfrank.javarouge.model.map.MapUtils;
import com.github.martinfrank.javarouge.model.map.RougeMap;
import com.github.martinfrank.javarouge.model.map.RougeMapField;
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
        Item steelDagger = new Item(objectsManager.getItem("Steel dagger"));
        RougeMapField daggerField = MazeGeneratorUtil.getRandomStartPosition(currentMap);
        currentMap.getField(daggerField.getIndex().getX(), daggerField.getIndex().getY())
                .getData().getItems().add(steelDagger);
        Entity goblin = new Entity(objectsManager.getMonster("Goblin"));
        RougeMapField goblinField = MazeGeneratorUtil.getRandomStartPosition(currentMap);
        currentMap.getField(goblinField.getIndex().getX(), goblinField.getIndex().getY())
                .getData().getEntities().add(goblin);

        RougeMapField field = MazeGeneratorUtil.getRandomStartPosition(currentMap);
        player.setPosition(field.getIndex().getX(), field.getIndex().getY());
    }

    public Player getPlayer() {
        return player;
    }

    public RougeMap getCurrentMap() {
        return currentMap;
    }

}
