package com.github.martinfrank.javarouge.view;

import com.github.martinfrank.javarouge.model.RougeGame;
import com.github.martinfrank.javarouge.model.map.RougeMap;
import com.github.martinfrank.javarouge.model.mapdata.RougeMapFieldData;
import com.github.martinfrank.javarouge.model.maze.Structure;
import com.github.martinfrank.javarouge.model.maze.Terrain;

import java.util.ArrayList;
import java.util.List;

public class TestView implements RougeView<List<String>> {

    private RougeGame model;

    @Override
    public List<String> display() {
        List<String> result = new ArrayList<>();
        RougeMap map = model.getMap();
        int rows = map.getRows();
        int columns = map.getColumns();

        for (int dy = 0; dy < rows; dy++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int dx = 0; dx < columns; dx++) {
                appendField(stringBuilder, map.getField(dx, dy).getData());
            }
            result.add(stringBuilder.toString());
        }
        return result;
    }

    private void appendField(StringBuilder stringBuilder, RougeMapFieldData fieldData) {
        Structure structure = fieldData.getStructure();
        if (structure != null) {
            appendStructure(stringBuilder, structure);
        } else {
            appendTerrain(stringBuilder, fieldData.getTerrain());
        }
    }

    private void appendStructure(StringBuilder stringBuilder, Structure structure) {
        stringBuilder.append(' ');
    }


    private void appendTerrain(StringBuilder stringBuilder, Terrain terrain) {
        stringBuilder.append(terrain == null ? '?' : '#');
    }

    @Override
    public void update(RougeGame model) {
        this.model = model;
    }
}
