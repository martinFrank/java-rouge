package com.github.martinfrank.javarouge.model.maze;

import com.github.martinfrank.javarouge.model.map.RougeMap;
import com.github.martinfrank.javarouge.model.mapdata.RougeMapFieldData;

public class MazeGenerator {

    public enum GeneratorType {CORRIDORS_AND_ROOMS}

    public static void generateMaze(RougeMap map, GeneratorType type) {
        int rows = map.getRows();
        int columns = map.getColumns();
        for (int dy = 0; dy < rows; dy++) {
            for (int dx = 0; dx < columns; dx++) {
                RougeMapFieldData fieldData = map.getField(dx, dy).getData();
                fieldData.setTerrain(Terrain.VOID);
            }
        }

        for (int dy = 1; dy < (rows - 1); dy++) {
            for (int dx = 1; dx < (columns - 1); dx++) {
                RougeMapFieldData fieldData = map.getField(dx, dy).getData();
                fieldData.setStructure(new Structure(Structure.Type.CORRIDOR));
            }
        }
    }
}
