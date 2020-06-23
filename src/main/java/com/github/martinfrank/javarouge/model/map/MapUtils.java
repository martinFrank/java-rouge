package com.github.martinfrank.javarouge.model.map;

import com.github.martinfrank.javarouge.model.maze.MazeGeneratorUtil;
import com.github.martinfrank.maplib.MapStyle;

public class MapUtils {

    public static RougeMap createMap(int width, int height) {
        RougeMapPartFactory mapPartFactory = new RougeMapPartFactory();
        RougeMapFactory mapFactory = new RougeMapFactory(mapPartFactory);
        RougeMap map = mapFactory.createMap(width, height, MapStyle.SQUARE4);
        MazeGeneratorUtil.generateMaze(map);
        return map;
    }
}
