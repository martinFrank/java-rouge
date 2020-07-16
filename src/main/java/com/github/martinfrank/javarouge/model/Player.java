package com.github.martinfrank.javarouge.model;

import com.github.martinfrank.geolib.GeoPoint;
import com.github.martinfrank.javarouge.model.map.HumanWalker;
import com.github.martinfrank.javarouge.model.map.RougeMapField;
import com.github.martinfrank.javarouge.model.map.RougeMapWalker;

public class Player {

    private final String name;
    private GeoPoint positionIndex;
    private RougeMapWalker walker;

    public Player(String name) {
        this.name = name;
        walker = new HumanWalker();
    }

    public void setPosition(int x, int y) {
        positionIndex = new GeoPoint(x, y);
    }

    public void setPosition(RougeMapField field) {
        setPosition(field.getIndex().getX(), field.getIndex().getY());
    }

    public GeoPoint getPosition() {
        return positionIndex;
    }

    public RougeMapWalker getWalker() {
        return walker;
    }
}
