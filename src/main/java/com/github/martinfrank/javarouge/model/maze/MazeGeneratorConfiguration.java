package com.github.martinfrank.javarouge.model.maze;

public class MazeGeneratorConfiguration {

    public Terrain terrain = Terrain.STONE;
    public GeneratorType generatorType = GeneratorType.CORRIDORS_AND_ROOMS;

    public Structure.Type getRoomStructureType() {
        return Structure.Type.ROOM;
    }

    public enum GeneratorType {CORRIDORS_AND_ROOMS}

    public MazeGeneratorConfiguration() {
    }
}
