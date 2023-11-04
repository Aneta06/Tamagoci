package com.greenfoxacademy.tamagochi.model.pets;

import com.greenfoxacademy.tamagochi.model.Edible;
import com.greenfoxacademy.tamagochi.model.Entertaining;
import com.greenfoxacademy.tamagochi.model.PetActions;
import com.greenfoxacademy.tamagochi.model.Washing;
import com.greenfoxacademy.tamagochi.model.pets.PetType;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public abstract class Pet implements PetActions {

    private static int ID = 1;

    private int id;
    private String name;
    private int hunger;
    private int happiness;
    private int dirtiness;
    private int tireness;
    private String image;
    private PetType type;
    private int maxHappiness;
    private int maxHunger;
    private int maxTireness;
    private int maxDirtiness;
    private String description;

    private static final int WEARINESS = 1; // for each play()
    private static final int STARVATION = 2; // for each play()
    private static final int STAINING = new Random().nextInt(3) + 1; // for each play()
    private static final int UNHAPPINESS = 4; // for each clean()

    public Pet(String name,
               int maxHunger,
               int maxHappiness,
               int maxTireness,
               int maxDirtiness,
               int hunger,
               int happiness,
               int tireness,
               int dirtiness,
               String imag,
               PetType type,
               String description
               ) {
        initId();
        this.name = name;
        this.maxHappiness = maxHappiness;
        this.maxHunger = maxHunger;
        this.maxTireness = maxTireness;
        this.maxDirtiness = maxDirtiness;
        this.hunger = hunger;
        this.happiness = happiness;
        this.dirtiness = dirtiness;
        this.tireness = tireness;
        this.image = imag;
        this.type = type;
        this.description = description;

    }

    private void initId(){
        this.id = ID++;
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
