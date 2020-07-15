package com.github.martinfrank.javarouge.model.mapdata;

import com.github.martinfrank.javarouge.model.entity.Entity;
import com.github.martinfrank.javarouge.model.entity.Item;
import com.github.martinfrank.javarouge.model.maze.Structure;
import com.github.martinfrank.javarouge.model.maze.Terrain;

import java.util.ArrayList;
import java.util.List;

public class RougeMapFieldData {

    private Terrain terrain;
    private Structure structure;
    private List<Entity> entities = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private boolean mazeGenerationVisited;

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

    public List<Entity> getEntities() {
        return entities;
    }

    public void setMazeGenerationVisited(boolean visited) {
        mazeGenerationVisited = visited;
    }

    public boolean isMazeGenerationVisited() {
        return mazeGenerationVisited;
    }

    public List<Item> getItems() {
        return items;
    }
}
