package com.github.martinfrank.javarouge.model.entity;

import com.github.martinfrank.javarouge.model.Player;
import com.github.martinfrank.javarouge.model.map.RougeMap;

public class Entity {

    private double turnTime;
    private final double velocity = 1;

    public void turnTime(double turnTime, Player player, RougeMap rougeMap) {
        this.turnTime = this.turnTime + turnTime;
        while (this.turnTime > velocity) {
            this.turnTime = this.turnTime - velocity;
            playTurn(player, rougeMap);
        }
    }

    private void playTurn(Player player, RougeMap rougeMap) {

    }
}
