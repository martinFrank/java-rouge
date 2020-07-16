package com.github.martinfrank.javarouge.model.map;

import com.github.martinfrank.javarouge.model.Player;
import com.github.martinfrank.javarouge.model.entity.Entity;
import com.github.martinfrank.javarouge.model.mapdata.RougeMapData;
import com.github.martinfrank.maplib.Map;
import com.github.martinfrank.maplib.MapStyle;

import java.util.List;

public class RougeMap extends Map<RougeMapData, RougeMapField, RougeMapEdge, RougeMapNode, RougeMapWalker> {


    RougeMap(int width, int height, MapStyle style, RougeMapData testMapData) {
        super(width, height, style, testMapData);
    }

    public void turnTime(double turnTime, Player player) {
        getEntities().forEach(e -> e.turnTime(turnTime, player, this));
    }

    private List<Entity> getEntities() {
        return RougeMapUtil.getEntities(this);
    }

    //Walk is ALWAYS ONE STEP (from one field to an adjected) - it's a WALK not a teleport or something
    public boolean canWalk(Player player, RougeMapField start, RougeMapField target) {
        return aStar(start, target, player.getWalker(), 100).size() >= 2;
    }

    public RougeMapField getField(Player player) {
        return RougeMapUtil.getField(this, player);
    }

    public RougeMapField getField(Entity entity) {
        return RougeMapUtil.getField(this, entity);
    }

    public void move(Entity entity, RougeMapField from, RougeMapField to) {
        from.getData().getEntities().remove(entity);
        to.getData().getEntities().add(entity);
    }
}
