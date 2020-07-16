package com.github.martinfrank.javarouge.model.map;

import com.github.martinfrank.javarouge.model.Player;
import com.github.martinfrank.javarouge.model.entity.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RougeMapUtil {

    public static RougeMapField getField(RougeMap map, Player player) {
        return map.getField(player.getPosition().getX(), player.getPosition().getY());
    }

    public static List<Entity> getEntities(RougeMap map) {
        List<Entity> entities = new ArrayList<>();
        map.getFields().forEach(f -> entities.addAll(f.getData().getEntities()));
        return entities;
    }

    public static RougeMapField getField(RougeMap map, Entity entity) {
        return map.getFields().stream().filter(f -> f.getData().getEntities().contains(entity)).findAny().orElse(null);
    }

    public static RougeMapField getRandomAccessablePosition(RougeMap map) {
        return getRandomAccessablePosition(map, new HumanWalker());
    }


    public static RougeMapField getRandomAccessablePosition(RougeMap map, RougeMapWalker walker) {
        List<RougeMapField> fields = new ArrayList<>(map.getFields());
        Collections.shuffle(fields);
        return fields.stream().filter(f -> walker.canEnter(f, f)).findAny().orElse(fields.get(0));
    }


}
