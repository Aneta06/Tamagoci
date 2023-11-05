package com.greenfoxacademy.tamagochi.service;

import com.greenfoxacademy.tamagochi.model.pets.*;
import com.greenfoxacademy.tamagochi.repository.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
    private PetRepo pets;


    public PetRepo getPetRepo() {
        return pets;
    }

    public void createPet(PetType type, String name, String description) {
        switch (type) {
            case FOX    : pets.addPet(new Fox(name, description)); break;
            case DOG    : pets.addPet(new Dog(name, description)); break;
            case TIGER  : pets.addPet(new Tiger(name, description)); break;
        }
    }
}
