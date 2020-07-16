package com.github.martinfrank.javarouge.model.entity;

import com.github.martinfrank.javarouge.model.Player;
import com.github.martinfrank.javarouge.model.map.HumanWalker;
import com.github.martinfrank.javarouge.model.map.RougeMap;
import com.github.martinfrank.javarouge.model.map.RougeMapField;
import com.github.martinfrank.javarouge.model.map.RougeMapWalker;
import com.github.martinfrank.javarouge.objects.MonsterPrototype;

import java.util.List;

public class Entity {

    private double turnTime;
    private final double velocity = 1.65567;
    private RougeMapField location;//FIXME hinterfragen!
    private final MonsterPrototype prototype;
    private final RougeMapWalker walker = new HumanWalker();

    public Entity(MonsterPrototype prototype) {
        this.prototype = prototype;
    }


    public void turnTime(double turnTime, Player player, RougeMap rougeMap) {
        this.turnTime = this.turnTime + turnTime;
        while (this.turnTime > velocity) {
            this.turnTime = this.turnTime - velocity;
            playTurn(player, rougeMap);
        }
    }

    private void playTurn(Player player, RougeMap rougeMap) {
        RougeMapField destiny = rougeMap.getField(player);
        RougeMapField start = rougeMap.getField(this);
        List<RougeMapField> path = rougeMap.aStar(start, destiny, walker, 100);
        if (path.size() > 2) {
            int lastButOne = path.size() - 2;
            rougeMap.move(this, start, path.get(lastButOne));
        }
    }

    public MonsterPrototype getPrototype() {
        return prototype;
    }
}
