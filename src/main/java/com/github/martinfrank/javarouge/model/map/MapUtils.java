package com.github.martinfrank.javarouge.model.map;

import com.github.martinfrank.maplib.MapStyle;

public class MapUtils {

    public static RougeMap createMap(int width, int height) {
        RougeMapPartFactory mapPartFactory = new RougeMapPartFactory();
        RougeMapFactory mapFactory = new RougeMapFactory(mapPartFactory);
        return mapFactory.createMap(width, height, MapStyle.SQUARE4);
    }
}
