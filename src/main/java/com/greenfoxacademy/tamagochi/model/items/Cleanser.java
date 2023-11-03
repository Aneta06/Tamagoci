package com.greenfoxacademy.tamagochi.model.items;

import com.greenfoxacademy.tamagochi.model.Washing;

public abstract class Cleanser extends Item implements Washing {

    private final int EFFECTIVITY;
    private final CleanserType TYPE;


    public Cleanser(String name, String imagePath, CleanserType type, int effectivity) {
        super(name, imagePath);
        this.EFFECTIVITY = effectivity;
        this.TYPE = type;
    }

    @Override
    public int wash() {
        return this.EFFECTIVITY;
    }
}
