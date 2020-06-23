package com.github.martinfrank.javarouge.model.maze;

import com.github.martinfrank.javarouge.model.map.RougeMap;
import com.github.martinfrank.javarouge.model.map.RougeMapField;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public abstract class MazeGenerator {

    public MazeGenerator() {
        random = new Random();
    }

    public MazeGenerator(long seed) {
        random = new Random(seed);
    }

    private final Random random;

    public abstract void generate(RougeMap rougeMap, MazeGeneratorConfiguration configuration);

    public void setBorder(RougeMap map) {
        int rows = map.getRows();
        int columns = map.getColumns();
        for (int dy = 0; dy < rows; dy++) {
            RougeMapField fieldW = map.getField(0, dy);
            RougeMapField fieldE = map.getField(columns - 1, dy);
            setBorderField(fieldW);
            setBorderField(fieldE);
        }
        for (int dx = 0; dx < columns; dx++) {
            RougeMapField fieldN = map.getField(dx, 0);
            RougeMapField fieldS = map.getField(dx, rows - 1);
            setBorderField(fieldN);
            setBorderField(fieldS);
        }
    }

    private void setBorderField(RougeMapField field) {
        field.getData().setStructure(Structure.BORDER);
    }

    public void generateMaze(RougeMap map, MazeGeneratorConfiguration configuration) {
        /*
         * 1. Choose the initial cell, mark it as visited and push it to the stack
         * 2. While the stack is not empty
         *    1. Pop a cell from the stack and make it a current cell
         *    2. If the current cell has any neighbours which have not been visited
         *       1. Push the current cell to the stack
         *       2. Choose one of the unvisited neighbours
         *       3. Remove the wall between the current cell and the chosen cell
         *       4. Mark the chosen cell as visited and push it to the stack
         */

        Stack<RougeMapField> stack = new Stack<>();
        RougeMapField initial = getInitialField(map);
        initial.getData().setMazeGenerationVisited(true);
        stack.push(initial);

        while (!stack.isEmpty()) {
            RougeMapField current = stack.pop();
            List<RougeMapField> notVisitedList = getNotVisitedList(current, map);
            if (!notVisitedList.isEmpty()) {
                stack.push(current);
                RougeMapField candidate = getRandom(notVisitedList);
                carve(current, candidate, map);
                candidate.getData().setMazeGenerationVisited(true);
                stack.push(candidate);
            }
        }

    }

    private void carve(RougeMapField from, RougeMapField to, RougeMap map) {
        int fx = from.getIndex().getX();
        int fy = from.getIndex().getY();
        int tx = to.getIndex().getX();
        int ty = to.getIndex().getY();
        int mx = (fx + tx) / 2;
        int my = (fy + ty) / 2;
        setCorridor(map, fx, fy);
        setCorridor(map, mx, my);
        setCorridor(map, tx, ty);
    }

    private void setCorridor(RougeMap map, int x, int y) {
        map.getField(x, y).getData().setStructure(new Structure(Structure.Type.CORRIDOR));
    }

    private List<RougeMapField> getNotVisitedList(RougeMapField current, RougeMap map) {
        int x = current.getIndex().getX();
        int y = current.getIndex().getY();
        List<RougeMapField> list = new ArrayList<>();
        addNotVisited(map.getField(x, y - 2), list);
        addNotVisited(map.getField(x + 2, y), list);
        addNotVisited(map.getField(x, y + 2), list);
        addNotVisited(map.getField(x - 2, y), list);
        return list;
    }

    private List<RougeMapField> getPassableNeighbours(RougeMapField current, RougeMap map) {
        int x = current.getIndex().getX();
        int y = current.getIndex().getY();
        List<RougeMapField> list = new ArrayList<>();
        addIfStructure(map.getField(x, y - 1), list);
        addIfStructure(map.getField(x + 1, y), list);
        addIfStructure(map.getField(x, y + 1), list);
        addIfStructure(map.getField(x - 1, y), list);
        return list;
    }

    private void addIfStructure(RougeMapField candidate, List<RougeMapField> list) {
        if (candidate != null && candidate.getData().getStructure() != null) {
            list.add(candidate);
        }
    }

    private void addNotVisited(RougeMapField candidate, List<RougeMapField> list) {
        if (candidate != null && !candidate.getData().isMazeGenerationVisited())
            list.add(candidate);
    }


    private RougeMapField getRandom(List<RougeMapField> list) {
        return list.get(random.nextInt(list.size()));
    }

    private RougeMapField getInitialField(RougeMap map) {
        return map.getField(1, 1);
    }

    public void removeDeadEnd(RougeMap map) {
        List<RougeMapField> candidates = new ArrayList<>();
        for (RougeMapField field : map.getFields()) {
            List<RougeMapField> neighbours = getPassableNeighbours(field, map);
            if (neighbours.size() == 1) {
                candidates.add(field);
            }
        }
        candidates.forEach(c -> c.getData().setStructure(null));
    }
}
