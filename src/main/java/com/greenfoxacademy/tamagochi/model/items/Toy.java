package com.greenfoxacademy.tamagochi.model.items;

import com.greenfoxacademy.tamagochi.model.Entertaining;

public abstract class Toy extends Item implements Entertaining {

    private final int ENTERTAINMENT_LEVEL;
    private final ToyType TYPE;
    public Toy(String name, String imagePath, ToyType type, int entertainmentLevel) {
        super(name, imagePath);
        this.ENTERTAINMENT_LEVEL = entertainmentLevel;
        this.TYPE = type;
    }

    @Override
    public int entertain() {
        return this.ENTERTAINMENT_LEVEL;
    }
}
