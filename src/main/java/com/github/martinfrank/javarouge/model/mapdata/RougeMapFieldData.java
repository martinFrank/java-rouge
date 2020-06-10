package com.github.martinfrank.javarouge.model.mapdata;

import com.github.martinfrank.javarouge.model.entity.Entity;
import com.github.martinfrank.javarouge.model.maze.Structure;
import com.github.martinfrank.javarouge.model.maze.Terrain;

import java.util.ArrayList;
import java.util.Collection;

public class RougeMapFieldData {

    private Terrain terrain;
    private Structure structure;
    private Collection<Entity> entities = new ArrayList<>();

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public Collection<Entity> getEntities() {
        return entities;
    }
}
