package com.greenfoxacademy.tamagochi.service;

import com.greenfoxacademy.tamagochi.repository.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
    private PetRepo repo;

    public PetRepo getRepo() {
        return repo;
    }
}
