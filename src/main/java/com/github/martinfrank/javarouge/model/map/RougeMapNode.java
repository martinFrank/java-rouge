package com.github.martinfrank.javarouge.model.map;

import com.github.martinfrank.javarouge.model.mapdata.RougeMapNodeData;
import com.github.martinfrank.maplib.MapNode;

public class RougeMapNode extends MapNode<RougeMapNodeData, RougeMapField, RougeMapEdge, RougeMapNode> {

    public RougeMapNode(RougeMapNodeData data) {
        super(data);
    }

}

