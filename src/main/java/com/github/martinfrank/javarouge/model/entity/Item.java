package com.github.martinfrank.javarouge.model.entity;

import com.github.martinfrank.javarouge.objects.ItemPrototype;

public class Item {

    private final ItemPrototype itemPrototype;

    public Item(ItemPrototype itemPrototype) {
        this.itemPrototype = itemPrototype;
    }

    public ItemPrototype getPrototype() {
        return itemPrototype;
    }
}
