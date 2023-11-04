package com.greenfoxacademy.tamagochi.model.pets;

import java.util.Random;

public class Tiger extends Pet {

    private static final int MAX_HUNGER = 10;
    private static final int MAX_HAPPINESS = 8;
    private static final int MAX_TIRENESS = 7;
    private static final int MAX_DIRTINESS = 5;

    public Tiger(String name, String description) {
        super(name,
                PetsStats.TIGER_MAX_HUNGER,
                PetsStats.TIGER_MAX_HAPPINESS,
                PetsStats.TIGER_MAX_TIRENESS,
                PetsStats.TIGER_MAX_DIRTINESS,
                new Random().nextInt(PetsStats.TIGER_MAX_HUNGER),
                new Random().nextInt(PetsStats.TIGER_MAX_HAPPINESS),
                new Random().nextInt(PetsStats.TIGER_MAX_TIRENESS),
                new Random().nextInt(PetsStats.TIGER_MAX_DIRTINESS),
                "images/tiger.jpg",
                PetType.TIGER,
                description);
    }
}
