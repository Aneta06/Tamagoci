package com.greenfoxacademy.tamagochi.repository;

import com.greenfoxacademy.tamagochi.model.pets.Dog;
import com.greenfoxacademy.tamagochi.model.pets.Pet;
import com.greenfoxacademy.tamagochi.model.pets.Fox;
import com.greenfoxacademy.tamagochi.model.pets.Tiger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class PetRepo {

    private List<Pet> pets;

    public PetRepo() {
        this.pets = new ArrayList<>();
        pets.add(new Tiger("Anet", "Hello I'm main programmer of this app!" ));
        pets.add(new Fox("Pavel", "Hello I'm main designer of this bullshit!" ));
        pets.add(new Dog("Malik", "Hello I'm mascot of this project!"));
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public Optional<Pet> getPet(int petID) {
        return pets.stream()
                .filter(p -> p.getId() == petID)
                .findFirst();
    }

    public List<Pet> getPets() {
        return pets;
    }
}
