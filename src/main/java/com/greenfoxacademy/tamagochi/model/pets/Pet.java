package com.greenfoxacademy.tamagochi.model.pets;

import com.greenfoxacademy.tamagochi.model.*;
import com.greenfoxacademy.tamagochi.model.items.Item;
import com.greenfoxacademy.tamagochi.model.pets.PetType;
import com.greenfoxacademy.tamagochi.repository.ItemRepo;
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
        correctStats();
    }

    @Override
    public void clean(Washing washing) {
        this.dirtiness -= washing.wash();
        this.happiness -= UNHAPPINESS;
        correctStats();
    }

    @Override
    public void sleep() {
        this.tireness -= new Random().nextInt(3) + 1;
        correctStats();
    }

    @Override
    public void play(Entertaining entertaining) {
        this.happiness += entertaining.entertain();
        this.tireness += WEARINESS;
        this.hunger += STARVATION;
        this.dirtiness += STAINING;
        correctStats();
    }

    public void use(Item item) {
        if (item instanceof Edible) {
            this.eat((Edible) item);
        }
        if(item instanceof Washing){
            this.clean((Washing) item);
        }
        if(item instanceof Entertaining){
            this.play((Entertaining) item);
        }
    }

    private void correctStats() {
        if (this.hunger > this.maxHunger) { this.hunger = this.maxHunger; }
        if (this.hunger < 0) { this.hunger = 0; }

        if (this.happiness > this.maxHappiness) { this.happiness = this.maxHappiness; }
        if (this.happiness < 0) { this.happiness = 0; }

        if (this.dirtiness > this.maxDirtiness) { this.dirtiness = this.maxDirtiness; }
        if (this.dirtiness < 0) { this.dirtiness = 0; }

        if (this.tireness > this.maxTireness) { this.tireness = this.maxTireness; }
        if (this.tireness < 0) { this.tireness = 0; }
    }
}
