package com.greenfoxacademy.tamagochi.controller;

import com.greenfoxacademy.tamagochi.model.items.Item;
import com.greenfoxacademy.tamagochi.model.pets.Pet;
import com.greenfoxacademy.tamagochi.model.pets.PetType;
import com.greenfoxacademy.tamagochi.service.ItemService;
import com.greenfoxacademy.tamagochi.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        Optional<Pet> optPet = petService.getPetRepo().getPet(petID);
        if (optPet.isPresent()) {
            model.addAttribute("name", optPet.get().getName());
            model.addAttribute("petID", optPet.get().getId());
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

            model.addAttribute("itemPool", itemService.getItems().getItems());
        } else {
            model.addAttribute("name", "Nothing found");
        }
        return "viewpet";
    }

    @PostMapping("/pet/use")
    public String useItem(@RequestParam("petID") int petID,
                          @RequestParam("itemID") int itemID) {

        Optional<Pet> optPet = petService.getPetRepo().getPet(petID);
        Optional<Item> optItem = itemService.getItems().getItem(itemID);
        if (optPet.isPresent() && optItem.isPresent()) {
            optPet.get().use(optItem.get());
            itemService.getItems().getItems().remove(optItem.get());
        }
        return "redirect:/pet/view?petID=" + petID;
    }


    @PostMapping("/pet/create")
    public String createPet(Model model,
                            @RequestParam("type") PetType type,
                            @RequestParam("name") String name,
                            @RequestParam("description") String description) {

        petService.createPet(type, name, description);
        model.addAttribute("petsPool", petService.getPetRepo().getPets());
        model.addAttribute("typePool", PetType.getTypes());
        return "redirect:/pets";
    }

    @GetMapping("/pets")
    public String showPets(Model model) {
        model.addAttribute("petsPool", petService.getPetRepo().getPets());
        model.addAttribute("typePool", PetType.getTypes());
        return "pets";
    }


}
