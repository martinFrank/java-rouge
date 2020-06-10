package com.github.martinfrank.javarouge.model.maze;

public class Structure {

    public enum Type {BRIDGE, CORRIDOR, DOOR, ROOM}

    private final Type type;

    public Structure(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
