package com.greenfoxacademy.tamagochi.model.items;

import com.greenfoxacademy.tamagochi.model.Edible;

public abstract class Food extends Item implements Edible {
    private final int SATURATION;
    private final FoodType TYPE;
    public Food(String name, String imagePath, FoodType type, int saturation) {
        super(name, imagePath);
        this.TYPE = type;
        this.SATURATION = saturation;
    }

    @Override
    public int disposeFood() {
        return this.SATURATION;
    }
}
