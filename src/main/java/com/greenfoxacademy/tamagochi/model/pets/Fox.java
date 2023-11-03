package com.greenfoxacademy.tamagochi.model.pets;

import com.greenfoxacademy.tamagochi.model.Pet;

import java.util.Random;

public class Fox extends Pet {

    private static final int MAX_HUNGER = 5;
    private static final int MAX_HAPPINESS = 5;
    private static final int MAX_TIRENESS = 5;
    private static final int MAX_DIRTINESS = 5;


    public Fox(String name) {
        super(name,
                new Random().nextInt(MAX_HUNGER),
                new Random().nextInt(MAX_HAPPINESS),
                new Random().nextInt(MAX_TIRENESS),
                new Random().nextInt(MAX_DIRTINESS),
                "images/fox.jpg",
                PetType.FOX);
    }
}
