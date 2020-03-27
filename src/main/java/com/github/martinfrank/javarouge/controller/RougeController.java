package com.github.martinfrank.javarouge.controller;

import com.github.martinfrank.javarouge.model.RougeGame;
import com.github.martinfrank.javarouge.save.SaveGame;
import com.github.martinfrank.javarouge.view.BasicProgressMonitor;
import com.github.martinfrank.javarouge.view.ProgressMonitor;
import com.github.martinfrank.javarouge.view.RougeView;

public class RougeController<T> {

    private ProgressMonitor progressMonitor;
    private final RougeGame model;


    public RougeController(RougeView<T> view, RougeGame model) {
        this.model = model;
        progressMonitor = new BasicProgressMonitor();
    }

    public void loadSaveGame(SaveGame saveGame) {
        model.loadSaveGame(saveGame, progressMonitor);
    }

}
