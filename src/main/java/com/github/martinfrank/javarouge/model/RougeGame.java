package com.github.martinfrank.javarouge.model;

import com.github.martinfrank.geolib.GeoPoint;
import com.github.martinfrank.javarouge.model.map.RougeMap;
import com.github.martinfrank.javarouge.model.map.RougeMapField;
import com.github.martinfrank.javarouge.model.message.Message;
import com.github.martinfrank.javarouge.model.message.MessageConsumer;
import com.github.martinfrank.javarouge.model.rules.WalkCostRules;
import com.github.martinfrank.javarouge.save.SaveGame;
import com.github.martinfrank.maplib.Direction;

public class RougeGame {

    private RougeMap currentMap;
    private Player player;
    private double turnTime;
    private MessageConsumer messageConsumer;

    public void setCurrentMap(RougeMap currentMap) {
        this.currentMap = currentMap;
    }

    public void loadSaveGame(SaveGame saveGame) {
        currentMap = saveGame.getCurrentMap();
        player = saveGame.getPlayer();
        player.setPosition(3, 3);
    }

    public RougeMap getMap() {
        return currentMap;
    }

    public void movePlayer(Direction dir) {
        GeoPoint position = player.getPosition();
        RougeMapField start = currentMap.getField(position.getX(), position.getY());
        RougeMapField target = currentMap.getTarget(start, dir);
        double walkCost = WalkCostRules.getEnteringTerrainCosts(target.getData().getTerrain(), player);
        turnTime(walkCost);
        player.setPosition(position.getX() + dir.getDx(), position.getY() + dir.getDy());
        textMessage("you walk in direction " + dir);
    }

    private void textMessage(String message) {
        if (messageConsumer != null) {
            messageConsumer.receive(new Message(Message.Type.TEXT, message));
        }
    }

    private void turnTime(double turnTime) {
        this.turnTime = this.turnTime + turnTime;
        currentMap.turnTime(turnTime, player);
    }

    public Player getPlayer() {
        return player;
    }

    public void registerMessageConsumer(MessageConsumer messageConsumer) {
        this.messageConsumer = messageConsumer;
    }

}
