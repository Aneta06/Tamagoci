package com.greenfoxacademy.tamagochi.model.pets;

import java.util.Random;

public class Dog extends Pet {

    private static final int MAX_HUNGER = 8;
    private static final int MAX_HAPPINESS = 8;
    private static final int MAX_TIRENESS = 8;
    private static final int MAX_DIRTINESS = 10;

    public Dog(String name) {
        super(name,
                new Random().nextInt(MAX_HUNGER),
                new Random().nextInt(MAX_HAPPINESS),
                new Random().nextInt(MAX_TIRENESS),
                new Random().nextInt(MAX_DIRTINESS),
                "images/dog.jpg",
                PetType.DOG);
    }
}
