package com.greenfoxacademy.tamagochi.model;

import com.greenfoxacademy.tamagochi.model.pets.PetType;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public abstract class Pet implements PetActions  {


    private String name;
    private int hunger;
    private int happiness;
    private int dirtiness;
    private int cleanliness;
    private int tireness;
    private String image;
    private PetType type;
    private static final int WEARINESS = 1;
    private static final int STARVATION = 2;
    private static final int STAINING = new Random().nextInt(3) + 1;
    private static final int UNHAPPINESS = 4;

    public Pet(String name, int hunger, int happiness, int tireness, int dirtiness, String imag, PetType type) {
        this.name = name;
        this.hunger = hunger;
        this.happiness = happiness;
        this.dirtiness = dirtiness;
        this.tireness = tireness;
        this.image = imag;
        this.type = type;
    }



    @Override
    public String greet() {
        return String.format("Hello I'am %s and I'am your new %s",
                this.name,
                this.type);
    }

    @Override
    public void eat(Edible edible) {
        this.hunger -= edible.disposeFood();
    }

    @Override
    public void clean(Washing washing) {
        this.dirtiness -= washing.wash();
        this.happiness -= UNHAPPINESS;
    }

    @Override
    public void sleep() {
        this.tireness -= new Random().nextInt(3) + 1;
    }

    @Override
    public void play(Entertaining entertaining) {
        this.happiness += entertaining.entertain();
        this.tireness += WEARINESS;
        this.hunger += STARVATION;
        this.dirtiness += STAINING;
    }
}
