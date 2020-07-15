package com.github.martinfrank.javarouge.model.map;

import com.github.martinfrank.javarouge.objects.MonsterPrototype;
import com.github.martinfrank.maplib.MapStyle;

public class MapUtils {

    public static RougeMap createMap(int width, int height) {
        RougeMapPartFactory mapPartFactory = new RougeMapPartFactory();
        RougeMapFactory mapFactory = new RougeMapFactory(mapPartFactory);
        RougeMap map = mapFactory.createMap(width, height, MapStyle.SQUARE4);

//        populateMap(map);
        return map;
    }

    public static void populateMap(RougeMap map) {
        MonsterPrototype goblin = null;

    }
}
