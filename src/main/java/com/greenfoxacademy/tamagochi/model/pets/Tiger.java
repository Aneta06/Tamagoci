package com.greenfoxacademy.tamagochi.model.pets;

import java.util.Random;

public class Tiger extends Pet {

    public Tiger(String name, String description) {
        super(name,
                PetsStats.TIGER_MAX_HUNGER,
                PetsStats.TIGER_MAX_HAPPINESS,
                PetsStats.TIGER_MAX_TIREDNESS,
                PetsStats.TIGER_MAX_DIRTINESS,
                new Random().nextInt(PetsStats.TIGER_MAX_HUNGER),
                new Random().nextInt(PetsStats.TIGER_MAX_HAPPINESS),
                new Random().nextInt(PetsStats.TIGER_MAX_TIREDNESS),
                new Random().nextInt(PetsStats.TIGER_MAX_DIRTINESS),
                "/images/tiger.jpg",
                PetType.TIGER,
                description);
    }
}
