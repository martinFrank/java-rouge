package com.github.martinfrank.javarouge.model.entity;

import com.github.martinfrank.javarouge.model.Player;
import com.github.martinfrank.javarouge.model.map.RougeMap;
import com.github.martinfrank.javarouge.model.map.RougeMapField;
import com.github.martinfrank.javarouge.objects.MonsterPrototype;

public class Entity {

    private double turnTime;
    private final double velocity = 1.65567;
    private RougeMapField location;//FIXME hinterfragen!
    private final MonsterPrototype prototype;

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

    }

    public MonsterPrototype getPrototype() {
        return prototype;
    }
}
