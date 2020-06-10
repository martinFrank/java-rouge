package com.github.martinfrank.javarouge;

import com.github.martinfrank.javarouge.controller.RougeController;
import com.github.martinfrank.javarouge.model.Player;
import com.github.martinfrank.javarouge.model.RougeGame;
import com.github.martinfrank.javarouge.save.SaveGame;
import com.github.martinfrank.javarouge.view.RougeView;

public class Launcher {

    public static void main(String[] args) {
        RougeGame model = new RougeGame();
        RougeView<String> view = new RougeView<String>() {
            @Override
            public String display() {
                return null;
            }

            @Override
            public void update(RougeGame model) {

            }
        };

        RougeController<String> controller = new RougeController<>(view, model);

        SaveGame saveGame = new SaveGame(new Player("mosh"));
        controller.loadSaveGame(saveGame);
    }

}
