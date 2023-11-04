package com.greenfoxacademy.tamagochi.service;

import com.greenfoxacademy.tamagochi.repository.ItemRepo;
import com.greenfoxacademy.tamagochi.repository.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
    private PetRepo pets;


    public PetRepo getPets() {
        return pets;
    }

}
