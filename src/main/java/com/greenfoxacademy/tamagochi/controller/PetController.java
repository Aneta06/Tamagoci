package com.greenfoxacademy.tamagochi.controller;

import com.greenfoxacademy.tamagochi.model.pets.Pet;
import com.greenfoxacademy.tamagochi.repository.PetRepo;
import com.greenfoxacademy.tamagochi.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PetController {

    @Autowired
    PetService service;

    @GetMapping("/pet/view")
    public String viewPet(Model model, @RequestParam("petID") int petID) {
        Optional<Pet> optPet = service.getRepo().getPet(petID);
        if (optPet.isPresent()) {
            model.addAttribute("name", optPet.get().getName());
            model.addAttribute("imagePath", optPet.get().getImage());
            model.addAttribute("happiness", optPet.get().getHappiness());
            model.addAttribute("wasSuccessfullyFound", true);
        } else {
            model.addAttribute("wasSuccessfullyFound", false);
        }
        return "viewPet";
    }

}
