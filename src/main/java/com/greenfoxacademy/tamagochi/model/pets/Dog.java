package com.greenfoxacademy.tamagochi.model.pets;

import java.util.Random;

public class Dog extends Pet {

    public Dog(String name, String description) {
        super(name,
                PetsStats.DOG_MAX_HUNGER,
                PetsStats.DOG_MAX_HAPPINESS,
                PetsStats.DOG_MAX_TIREDNESS,
                PetsStats.DOG_MAX_DIRTINESS,
                new Random().nextInt(PetsStats.DOG_MAX_HUNGER),
                new Random().nextInt(PetsStats.DOG_MAX_HAPPINESS),
                new Random().nextInt(PetsStats.DOG_MAX_TIREDNESS),
                new Random().nextInt(PetsStats.DOG_MAX_DIRTINESS),
                "/images/dog.jpg",
                PetType.DOG,
                description);
    }
}
