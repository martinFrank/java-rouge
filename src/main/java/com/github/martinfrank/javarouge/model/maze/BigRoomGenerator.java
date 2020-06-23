package com.github.martinfrank.javarouge.model.maze;

import com.github.martinfrank.javarouge.model.map.RougeMap;
import com.github.martinfrank.javarouge.model.mapdata.RougeMapFieldData;

public class BigRoomGenerator extends MazeGenerator {

    @Override
    public void generate(RougeMap map, MazeGeneratorConfiguration configuration) {
        setBorder(map);
        int rows = map.getRows();
        int columns = map.getColumns();
        for (int dy = 1; dy < (rows - 1); dy++) {
            for (int dx = 1; dx < (columns - 1); dx++) {
                RougeMapFieldData fieldData = map.getField(dx, dy).getData();
                fieldData.setStructure(new Structure(Structure.Type.CORRIDOR));
            }
        }
    }


}
