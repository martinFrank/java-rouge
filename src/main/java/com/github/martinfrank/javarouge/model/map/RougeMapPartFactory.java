package com.github.martinfrank.javarouge.model.map;

import com.github.martinfrank.javarouge.model.mapdata.RougeMapData;
import com.github.martinfrank.javarouge.model.mapdata.RougeMapEdgeData;
import com.github.martinfrank.javarouge.model.mapdata.RougeMapFieldData;
import com.github.martinfrank.javarouge.model.mapdata.RougeMapNodeData;
import com.github.martinfrank.maplib.MapPartFactory;
import com.github.martinfrank.maplib.MapStyle;

public class RougeMapPartFactory extends MapPartFactory<RougeMap, RougeMapField, RougeMapEdge, RougeMapNode, RougeMapWalker> {

    @Override
    public RougeMapNode createMapNode() {
        return new RougeMapNode(new RougeMapNodeData());
    }

    @Override
    public RougeMapEdge createMapEdge() {
        return new RougeMapEdge(new RougeMapEdgeData());
    }

    @Override
    public RougeMapField createMapField() {
        return new RougeMapField(new RougeMapFieldData());
    }

    @Override
    public RougeMap createMap(int columns, int rows, MapStyle style) {
        return new RougeMap(columns, rows, style, new RougeMapData());
    }

    @Override
    public RougeMapWalker createWalker() {
        return new RougeMapWalker();
    }
}
