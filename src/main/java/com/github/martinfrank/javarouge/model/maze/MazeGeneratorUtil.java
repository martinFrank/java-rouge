package com.github.martinfrank.javarouge.model.maze;

import com.github.martinfrank.javarouge.model.map.RougeMap;
import com.github.martinfrank.javarouge.model.mapdata.RougeMapFieldData;

public class MazeGeneratorUtil {

    public static void generateMaze(RougeMap map) {
        generateMaze(map, new MazeGeneratorConfiguration());
    }

    public static void generateMaze(RougeMap map, MazeGeneratorConfiguration configuration) {
        MazeGenerator generator = getGenerator(configuration.generatorType);
        fillTerrain(map, Terrain.STONE);
        generator.generate(map, configuration);
    }


    private static void fillTerrain(RougeMap map, Terrain terrain) {
        int rows = map.getRows();
        int columns = map.getColumns();
        for (int dy = 0; dy < rows; dy++) {
            for (int dx = 0; dx < columns; dx++) {
                RougeMapFieldData fieldData = map.getField(dx, dy).getData();
                fieldData.setTerrain(terrain);
            }
        }
    }

    private static MazeGenerator getGenerator(MazeGeneratorConfiguration.GeneratorType type) {
        switch (type) {
            case CORRIDORS_AND_ROOMS:
                return new CorridorAndRoomsMazeGenerator();
            default:
                return new BigRoomGenerator();
        }
    }
}
