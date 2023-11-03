package com.greenfoxacademy.tamagochi.repository;

import com.greenfoxacademy.tamagochi.model.Pet;
import com.greenfoxacademy.tamagochi.model.pets.Fox;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class PetRepo {


    private List<Pet> pets;

    public PetRepo() {
        this.pets = new ArrayList<>();
        pets.add(new Fox("Pavel"));
    }
}
