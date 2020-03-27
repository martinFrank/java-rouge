package com.github.martinfrank.javarouge.model.map;

import com.github.martinfrank.maplib.MapWalker;

import java.util.List;

public class RougeMapWalker extends MapWalker<RougeMapField, RougeMapEdge, RougeMapNode> {
    @Override
    public boolean canEnter(RougeMapField from, RougeMapField into) {
        return true;
    }

    @Override
    public int getEnterCosts(RougeMapField from, RougeMapField into) {
        return 10;
    }

    @Override
    public List<RougeMapField> getNeighbours(RougeMapField field) {
        return getNeighboursFromNodes(field);//this one can walk diagonal
    }
}
