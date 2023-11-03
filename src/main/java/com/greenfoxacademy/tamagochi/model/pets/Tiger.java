package com.greenfoxacademy.tamagochi.model.pets;

import com.greenfoxacademy.tamagochi.model.Pet;

import java.util.Random;

public class Tiger extends Pet {

    private static final int MAX_HUNGER = 10;
    private static final int MAX_HAPPINESS = 8;
    private static final int MAX_TIRENESS = 7;
    private static final int MAX_DIRTINESS = 5;

    public Tiger(String name) {
        super(name,
                new Random().nextInt(MAX_HUNGER),
                new Random().nextInt(MAX_HAPPINESS),
                new Random().nextInt(MAX_TIRENESS),
                new Random().nextInt(MAX_DIRTINESS),
                "images/tiger.jpg",
                PetType.TIGER);
    }
}
