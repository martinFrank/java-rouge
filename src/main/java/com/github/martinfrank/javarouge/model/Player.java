package com.github.martinfrank.javarouge.model;

import com.github.martinfrank.geolib.GeoPoint;

public class Player {

    private final String name;
    private GeoPoint positionIndex;

    public Player(String name) {
        this.name = name;
    }

    public void setPosition(int x, int y) {
        positionIndex = new GeoPoint(x, y);
    }

    public GeoPoint getPosition() {
        return positionIndex;
    }
}
