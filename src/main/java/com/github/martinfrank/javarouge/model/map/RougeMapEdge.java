package com.github.martinfrank.javarouge.model.map;

import com.github.martinfrank.javarouge.model.mapdata.RougeMapEdgeData;
import com.github.martinfrank.maplib.MapEdge;

public class RougeMapEdge extends MapEdge<RougeMapEdgeData, RougeMapField, RougeMapEdge, RougeMapNode> {

    public RougeMapEdge(RougeMapEdgeData testEdgeData) {
        super(testEdgeData);
    }

}
