package com.greenfoxacademy.tamagochi.controller;

import com.greenfoxacademy.tamagochi.model.items.Item;
import com.greenfoxacademy.tamagochi.model.pets.Pet;
import com.greenfoxacademy.tamagochi.model.pets.PetType;
import com.greenfoxacademy.tamagochi.service.ItemService;
import com.greenfoxacademy.tamagochi.service.PetService;
import com.greenfoxacademy.tamagochi.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PetController {

    private final PetService petService;
    private final ItemService itemService;

    public PetController(PetService petService, ItemService itemService) {
        this.petService = petService;
        this.itemService = itemService;
    }

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
            model.addAttribute("maxHunger", optPet.get().getMaxHunger());
            model.addAttribute("happiness", optPet.get().getHappiness());
            model.addAttribute("maxHappiness", optPet.get().getMaxHappiness());
            model.addAttribute("tiredness", optPet.get().getTiredness());
            model.addAttribute("maxTiredness", optPet.get().getMaxTiredness());
            model.addAttribute("dirtiness", optPet.get().getDirtiness());
            model.addAttribute("maxDirtiness", optPet.get().getMaxDirtiness());

            model.addAttribute("itemPool", itemService.getItemRepo().getItems());
        } else {
            model.addAttribute("name", "Nothing found");
        }
        return "viewPet";
    }

    @PostMapping("/pet/use")
    public String useItem(@RequestParam("petID") int petID,
                          @RequestParam("itemID") int itemID) {

        Optional<Pet> optPet = petService.getPetRepo().getPet(petID);
        Optional<Item> optItem = itemService.getItemRepo().getItem(itemID);

        if (optPet.isPresent() && optItem.isPresent()) {
            Pet pet = optPet.get();
            Item item = optItem.get();

            pet.use(item);
            itemService.getItemRepo().getItems().remove(item);
            item = null;

            if(!pet.isAlive()) {
                petService.getPetRepo().getPets().remove(pet);
                pet = null;
                return "redirect:/pets";
            }
        }
        return "redirect:/pet/view?petID=" + petID;
    }

    @GetMapping("/pet/createForm")
    public String createForm(Model model) {
        model.addAttribute("typePool", PetType.getTypes());
        model.addAttribute("randomName", Util.getRandomName());
        model.addAttribute("randomDescription", Util.getRandomDescription());
        return "createPet";
    }

    @GetMapping("/pet/createBlank")
    public String createBlankForm(Model model) {
        model.addAttribute("typePool", PetType.getTypes());
        return "createPet";
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

    @GetMapping("/pet/removeForm")
    public String removeForm(Model model) {

        model.addAttribute("petsPool", petService.getPetRepo().getPets());
        return "remove";
    }

    @PostMapping("/pet/removePet")
    public String removePet(@RequestParam("petID") int petID) {

        if (petService.getPetRepo().getPet(petID).isPresent()) {
            petService.getPetRepo().getPets().remove(petService.getPetRepo().getPet(petID).get());
        }
        return "redirect:/pet/removeForm";
    }

    @PostMapping("/pet/removeAll")
    public String removeAll() {
        petService.getPetRepo().getPets().clear();
        return "redirect:/pet/createForm";
    }

    @GetMapping("/pets")
    public String showPets(Model model) {
        model.addAttribute("petsPool", petService.getPetRepo().getPets());
        model.addAttribute("typePool", PetType.getTypes());
        return "pets";
    }

    @PostMapping("/pet/sleep")
    public String sleep(@RequestParam("petID") int petID) {
        if (petService.getPetRepo().getPet(petID).isPresent()) {
            petService.getPetRepo().getPet(petID).get().sleep();
        }
        return "redirect:/pet/view?petID=" + petID;
    }
}
