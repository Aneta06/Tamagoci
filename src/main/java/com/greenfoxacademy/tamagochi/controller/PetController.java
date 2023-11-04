package com.greenfoxacademy.tamagochi.controller;

import com.greenfoxacademy.tamagochi.model.pets.Pet;
import com.greenfoxacademy.tamagochi.service.ItemService;
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
    PetService petService;
    @Autowired
    ItemService itemService;

    @GetMapping("/pet/view")
    public String viewPet(Model model, @RequestParam("petID") int petID) {
        Optional<Pet> optPet = petService.getPets().getPet(petID);
        if (optPet.isPresent()) {
            model.addAttribute("name", optPet.get().getName());
            model.addAttribute("imagePath", optPet.get().getImage());
            model.addAttribute("type", optPet.get().getType());
            model.addAttribute("description", optPet.get().getDescription());

            model.addAttribute("hunger", optPet.get().getHunger());
            model.addAttribute("maxhunger", optPet.get().getMaxHunger());

            model.addAttribute("happiness", optPet.get().getHappiness());
            model.addAttribute("maxhappiness", optPet.get().getMaxHappiness());

            model.addAttribute("tireness", optPet.get().getTireness());
            model.addAttribute("maxtireness", optPet.get().getMaxTireness());

            model.addAttribute("dirtiness", optPet.get().getDirtiness());
            model.addAttribute("maxdirtiness", optPet.get().getMaxDirtiness());

            model.addAttribute("itemPool", itemService.getItems());


            model.addAttribute("wasSuccessfullyFound", true);
        } else {
            model.addAttribute("wasSuccessfullyFound", false);
        }
        return "viewPet";
    }

}
