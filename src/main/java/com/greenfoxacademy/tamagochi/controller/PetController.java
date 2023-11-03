package com.greenfoxacademy.tamagochi.controller;

import com.greenfoxacademy.tamagochi.repository.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PetController {

    @Autowired
    private PetRepo repo;

//    @GetMapping("/")

}
