package com.github.martinfrank.javarouge.model.maze;

public class Structure {

    public enum Type {
        BRIDGE, CORRIDOR, DOOR, BORDER, ROOM, ROOM_OUTER_BORDER, ROOM_INNER_BORDER, ROOM_OUTER_CORNER;

    }

    public static final Structure BORDER = new Structure(Type.BORDER);

    private final Type type;

    public Structure(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
