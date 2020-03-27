package com.github.martinfrank.javarouge.model.map;

import com.github.martinfrank.maplib.MapFactory;
import com.github.martinfrank.maplib.MapPartFactory;

public class RougeMapFactory extends MapFactory<RougeMap, RougeMapField, RougeMapEdge, RougeMapNode, RougeMapWalker> {

    public RougeMapFactory(MapPartFactory<RougeMap, RougeMapField, RougeMapEdge, RougeMapNode, RougeMapWalker> mapPartFactory) {
        super(mapPartFactory);
    }

}
