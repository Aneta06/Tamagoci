package com.greenfoxacademy.tamagochi.model.pets;

import java.util.Random;

public class Fox extends Pet {

    private static final int MAX_HUNGER = 5;
    private static final int MAX_HAPPINESS = 10;
    private static final int MAX_TIRENESS = 5;
    private static final int MAX_DIRTINESS = 7;

    public Fox(String name) {
        super(name,
                new Random().nextInt(MAX_HUNGER),
                new Random().nextInt(MAX_HAPPINESS),
                new Random().nextInt(MAX_TIRENESS),
                new Random().nextInt(MAX_DIRTINESS),
                "/images/fox.jpg",
                PetType.FOX);
    }

    public int getMaxHunger() { return MAX_HUNGER; }
    public int getMaxHappiness() { return MAX_HAPPINESS; }
    public int getMaxTireness() { return MAX_TIRENESS; }
    public int getMaxDirtiness() { return MAX_DIRTINESS; }
}
