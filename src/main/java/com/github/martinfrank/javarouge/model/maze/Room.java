package com.github.martinfrank.javarouge.model.maze;

import com.github.martinfrank.javarouge.model.map.RougeMap;
import com.github.martinfrank.javarouge.model.map.RougeMapField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private static final Logger LOGGER = LoggerFactory.getLogger(Room.class);

    private final int width;
    private final int height;

    public Room(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getPlacingValue(RougeMapField nw, RougeMap map) {
        boolean anyHit = false;
        List<RougeMapField> outerBorder = getOuterBorder(nw, map);
        int outerBorderSize = 2 * (width + height);
        if (outerBorder.size() < outerBorderSize) {
            return Integer.MIN_VALUE;
        }
        int outerBorderValue = 0;
        for (RougeMapField field : outerBorder) {
            if (isEmpty(field)) {
                outerBorderValue = outerBorderValue + 100;
            }
            if (isCorridor(field)) {
                anyHit = true;
                outerBorderValue = outerBorderValue - 1000;
            }
            if (isRoom(field)) {
                outerBorderValue = outerBorderSize - 10000;
            }
        }

        for (RougeMapField field : getOuterCorners(nw, map)) {
            if (isEmpty(field)) {
                outerBorderValue = outerBorderValue + 1000;
            }
            if (isCorridor(field)) {
                anyHit = true;
                outerBorderValue = outerBorderValue - 10000;
            }
            if (isRoom(field)) {
                outerBorderValue = outerBorderSize - 10000;
            }
        }
        for (RougeMapField field : getRoomFields(nw, map)) {
            if (isRoom(field)) {
                outerBorderValue = outerBorderSize - 10000;
            }
        }

        if (anyHit) {
            return outerBorderValue;
        }
        return Integer.MIN_VALUE;
    }

    private boolean isRoom(RougeMapField field) {
        return field.getData().getStructure() != null &&
                field.getData().getStructure().getType() == Structure.Type.ROOM;
    }

    private boolean isCorridor(RougeMapField field) {
        return field.getData().getStructure() != null &&
                field.getData().getStructure().getType() == Structure.Type.CORRIDOR;
    }

    private boolean isEmpty(RougeMapField field) {
        return field.getData().getStructure() != null &&
                field.getData().getStructure().getType() == null;
    }

    private boolean isInvalid(RougeMapField field) {
        return field == null;
    }

    public List<RougeMapField> getInnerBorder(RougeMapField nw, RougeMap map) {
        List<RougeMapField> fields = new ArrayList<>();
        for (int dy = 0; dy < height; dy++) {
            int xw = nw.getIndex().getX();
            int xe = nw.getIndex().getX() + width - 1;
            int y = nw.getIndex().getY() + dy;
            addIfExists(map.getField(xw, y), fields);
            addIfExists(map.getField(xe, y), fields);
        }
        for (int dx = 1; dx < width - 1; dx++) {
            int x = nw.getIndex().getX() + dx;
            int yn = nw.getIndex().getY();
            int ys = nw.getIndex().getY() + height - 1;
            addIfExists(map.getField(x, yn), fields);
            addIfExists(map.getField(x, ys), fields);
        }
        return fields;
    }

    public List<RougeMapField> getOuterCorners(RougeMapField nw, RougeMap map) {
        List<RougeMapField> fields = new ArrayList<>();
        int x = nw.getIndex().getX();
        int y = nw.getIndex().getY();
        addIfExists(map.getField(x - 1, y - 1), fields);
        addIfExists(map.getField(x + width, y - 1), fields);
        addIfExists(map.getField(x - 1, y + height), fields);
        addIfExists(map.getField(x + width, y + height), fields);
        return fields;
    }

    public List<RougeMapField> getOuterBorder(RougeMapField nw, RougeMap map) {
        List<RougeMapField> fields = new ArrayList<>();
        for (int dy = -1; dy < height + 1; dy++) {
            int xw = nw.getIndex().getX() - 1;
            int xe = nw.getIndex().getX() + width;
            int y = nw.getIndex().getY() + dy;
            addIfExists(map.getField(xw, y), fields);
            addIfExists(map.getField(xe, y), fields);
        }
        for (int dx = 0; dx < width; dx++) {
            int x = nw.getIndex().getX() + dx;
            int yn = nw.getIndex().getY() - 1;
            int ys = nw.getIndex().getY() + height;
            addIfExists(map.getField(x, yn), fields);
            addIfExists(map.getField(x, ys), fields);
        }
        return fields;
    }

    private void addIfExists(RougeMapField field, List<RougeMapField> fields) {
        if (field != null) {
            fields.add(field);
        }
    }

    public List<RougeMapField> getRoomFields(RougeMapField nw, RougeMap map) {
        List<RougeMapField> fields = new ArrayList<>();
        for (int dy = 0; dy < height; dy++) {
            for (int dx = 0; dx < width; dx++) {
                int x = nw.getIndex().getX() + dx;
                int y = nw.getIndex().getY() + dy;
                RougeMapField field = map.getField(x, y);
                if (field != null) {
                    fields.add(field);
                }
            }
        }
        return fields;
    }


}
