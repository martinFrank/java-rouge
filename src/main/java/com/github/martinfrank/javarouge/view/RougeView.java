package com.github.martinfrank.javarouge.view;

import com.github.martinfrank.javarouge.model.RougeGame;

public interface RougeView<V> {

    V display();

    void update(RougeGame model);
}
