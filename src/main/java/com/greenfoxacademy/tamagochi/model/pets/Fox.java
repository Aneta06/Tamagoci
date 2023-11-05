package com.greenfoxacademy.tamagochi.model.pets;

import java.util.Random;

public class Fox extends Pet {

    public Fox(String name, String description) {
        super(name,
                PetsStats.FOX_MAX_HUNGER,
                PetsStats.FOX_MAX_HAPPINESS,
                PetsStats.FOX_MAX_TIREDNESS,
                PetsStats.FOX_MAX_DIRTINESS,
                new Random().nextInt(PetsStats.FOX_MAX_HUNGER),
                new Random().nextInt( PetsStats.FOX_MAX_HAPPINESS),
                new Random().nextInt(PetsStats.FOX_MAX_TIREDNESS),
                new Random().nextInt(PetsStats.FOX_MAX_DIRTINESS),
                "/images/fox.jpg",
                PetType.FOX,
                description);
    }


}
