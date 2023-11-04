package com.greenfoxacademy.tamagochi.repository;

import com.greenfoxacademy.tamagochi.model.pets.Pet;
import com.greenfoxacademy.tamagochi.model.pets.Fox;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class PetRepo {

    private List<Pet> pets;

    public PetRepo() {
        this.pets = new ArrayList<>();
        pets.add(new Fox("Pavel"));
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public Optional<Pet> getPet(int petID) {
        return pets.stream()
                .filter(p -> p.getId() == petID)
                .findFirst();
    }
}
