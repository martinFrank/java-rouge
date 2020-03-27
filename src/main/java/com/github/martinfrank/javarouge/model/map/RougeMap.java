package com.github.martinfrank.javarouge.model.map;

import com.github.martinfrank.javarouge.model.mapdata.RougeMapData;
import com.github.martinfrank.maplib.Map;
import com.github.martinfrank.maplib.MapStyle;

public class RougeMap extends Map<RougeMapData, RougeMapField, RougeMapEdge, RougeMapNode, RougeMapWalker> {


    RougeMap(int width, int height, MapStyle style, RougeMapData testMapData) {
        super(width, height, style, testMapData);
    }

}
