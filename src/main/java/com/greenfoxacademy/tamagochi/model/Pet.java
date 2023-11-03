package com.greenfoxacademy.tamagochi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public abstract class Pet implements PetActions  {


    private String name;
    private int hunger;
    private int hapiness;
    private int dirtiness;
    private int cleanliness;
    private int tireness;
    private String greetMessage;
    private String image;



    public Pet(String name, int hunger, int hapiness, int tireness, int dirtiness, String greetMessage, String imag) {
        this.name = name;
        this.hunger = hunger;
        this.hapiness = hapiness;
        this.dirtiness = dirtiness;
        this.tireness = tireness;
        this.greetMessage = greetMessage;
        this.image = imag;
    }



    @Override
    public String greet() {
        return String.format("Hello I'am %s and I'am your new %s",
                this.name,
                this.petType);
    }

    @Override
    public void eat(Edible edible) {
        this.hunger -= edible.saturation;
    }

    @Override
    public void clean(Washing washing) {
        this.dirtiness -= washing.effectivity;
    }

    @Override
    public void sleep() {
        this.tireness -= new Random().nextInt(3) + 1;
    }

    @Override
    public void play(Entertaining entertaining) {
        this.hapiness += entertaining.entertainmentLevel;

    }
}
