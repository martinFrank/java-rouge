package com.github.martinfrank.javarouge.view;

import com.github.martinfrank.javarouge.model.RougeGame;
import com.github.martinfrank.javarouge.model.map.RougeMap;
import com.github.martinfrank.javarouge.model.map.RougeMapFactory;
import com.github.martinfrank.javarouge.model.map.RougeMapPartFactory;
import com.github.martinfrank.javarouge.model.maze.MazeGenerator;
import com.github.martinfrank.maplib.MapStyle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class RogeViewTest {

    private RougeGame model;

    @Before
    public void setup() {
        RougeMapPartFactory partFactory = new RougeMapPartFactory();
        RougeMapFactory factory = new RougeMapFactory(partFactory);
        RougeMap map = factory.createMaze(7, 5, MapStyle.SQUARE4, MazeGenerator.GeneratorType.CORRIDORS_AND_ROOMS);
        model = new RougeGame();
        model.setCurrentMap(map);
    }

    @Test
    public void testView() {
        //given
        TestView view = new TestView();

        //when
        view.update(model);

        //then
        List<String> screen = view.display();
        Assert.assertNotNull(screen);
        screen.forEach(System.out::println);

        System.out.println("\u23d0\u231d\u23af");
    }
}
