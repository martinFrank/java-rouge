package com.github.martinfrank.javarouge.model.map;

import com.github.martinfrank.javarouge.model.maze.Structure;

public class HumanWalker extends RougeMapWalker {

    @Override
    public boolean canEnter(RougeMapField from, RougeMapField into) {
        if (into.getData().getStructure() == null) {
            return false;
        }
        if (into.getData().getStructure().getType() == Structure.Type.CORRIDOR) {
            return true;
        }
        if (into.getData().getStructure().getType() == Structure.Type.ROOM) {
            return true;
        }
        return false;
    }
}
