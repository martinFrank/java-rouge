package com.github.martinfrank.javarouge.model.maze;

import com.github.martinfrank.javarouge.model.map.RougeMap;
import com.github.martinfrank.javarouge.model.map.RougeMapField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class CorridorAndRoomsMazeGenerator extends MazeGenerator {

    private final Random random = new Random();

    private static final Logger LOGGER = LoggerFactory.getLogger(CorridorAndRoomsMazeGenerator.class);

    @Override
    public void generate(RougeMap map, MazeGeneratorConfiguration configuration) {
        generateMaze(map, configuration);
        for (int i = 0; i < 10; i++) { //FIXME i depending on map size and configuration
            removeDeadEnd(map);
        }

        for (int i = 0; i < 6; i++) { //FIXME i depending on map size and configuration
            insertRooms(map, configuration);
        }

//        for (int i = 0; i < 5; i ++) {
//            removeDeadEnd(map);
//    }

        setBorder(map);
    }

    private void insertRooms(RougeMap map, MazeGeneratorConfiguration configuration) {
        int roomWidth = 4 + random.nextInt(2);
        int roomHeight = 4 + random.nextInt(2);
        Room room = new Room(roomWidth, roomHeight);
        int value = Integer.MIN_VALUE;
        RougeMapField nw = null;
        List<RougeMapField> fields = new ArrayList<>(map.getFields());
        Collections.shuffle(fields);
        for (RougeMapField field : fields) {
            int currentValue = room.getPlacingValue(field, map);
            if (currentValue > value) {
                value = currentValue;
                nw = field;
            }
        }

        if (nw != null) {
            for (RougeMapField field : room.getRoomFields(nw, map)) {
                Structure.Type roomStructureType = configuration.getRoomStructureType();
                field.getData().setStructure(new Structure(roomStructureType));
            }
//            for (RougeMapField field : room.getOuterBorder(nw, map)) {
//                field.getData().setStructure(new Structure(Structure.Type.ROOM_OUTER_BORDER));
//            }
//            for (RougeMapField field : room.getInnerBorder(nw, map)) {
//                field.getData().setStructure(new Structure(Structure.Type.ROOM_INNER_BORDER));
//            }
//            for (RougeMapField field : room.getOuterCorners(nw, map)) {
//                field.getData().setStructure(new Structure(Structure.Type.ROOM_OUTER_CORNER));
//            }
        } else {
            LOGGER.debug("could not place room");
        }
    }

}
