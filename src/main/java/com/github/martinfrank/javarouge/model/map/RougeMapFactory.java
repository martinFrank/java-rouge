package com.github.martinfrank.javarouge.model.map;

import com.github.martinfrank.javarouge.model.maze.MazeGeneratorUtil;
import com.github.martinfrank.maplib.MapFactory;
import com.github.martinfrank.maplib.MapPartFactory;
import com.github.martinfrank.maplib.MapStyle;

public class RougeMapFactory extends MapFactory<RougeMap, RougeMapField, RougeMapEdge, RougeMapNode, RougeMapWalker> {

    public RougeMapFactory(MapPartFactory<RougeMap, RougeMapField, RougeMapEdge, RougeMapNode, RougeMapWalker> mapPartFactory) {
        super(mapPartFactory);
    }


    public RougeMap createMaze(int columns, int rows, MapStyle style) {
        RougeMap map = super.createMap(columns, rows, style);
        MazeGeneratorUtil.generateMaze(map);
        return map;
    }
}
