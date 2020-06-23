package com.github.martinfrank.javarouge.model.map;

import com.github.martinfrank.javarouge.model.Player;
import com.github.martinfrank.javarouge.model.entity.Entity;
import com.github.martinfrank.javarouge.model.mapdata.RougeMapData;
import com.github.martinfrank.maplib.Map;
import com.github.martinfrank.maplib.MapStyle;

import java.util.ArrayList;
import java.util.List;

public class RougeMap extends Map<RougeMapData, RougeMapField, RougeMapEdge, RougeMapNode, RougeMapWalker> {


    RougeMap(int width, int height, MapStyle style, RougeMapData testMapData) {
        super(width, height, style, testMapData);
    }

    public void turnTime(double turnTime, Player player) {
        getEntities().forEach(e -> e.turnTime(turnTime, player, this));
    }

    private List<Entity> getEntities() {
        List<Entity> entities = new ArrayList<>();
        getFields().forEach(f -> entities.addAll(f.getData().getEntities()));
        return entities;
    }

}
