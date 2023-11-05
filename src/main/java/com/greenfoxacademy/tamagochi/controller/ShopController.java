package com.greenfoxacademy.tamagochi.controller;

import com.greenfoxacademy.tamagochi.service.ItemService;
import com.greenfoxacademy.tamagochi.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ShopController {

    private final ShopService shopService;
    private final ItemService itemService;

    public ShopController(ShopService shopService, ItemService itemService) {
        this.shopService = shopService;
        this.itemService = itemService;
    }

    @GetMapping("/shop/view")
    public String viewShop(Model model,
                           @RequestParam("petID") Optional<Integer> petID) {

        if (petID.isPresent()) { model.addAttribute("petID", petID.get()); }
        model.addAttribute("shopItemsPool", shopService.getShopRepo().getShopItems());
        return "viewShop";
    }

    @PostMapping("/shop/buy")
    public String buyItem(@RequestParam("petID") Optional<Integer> petID,
                          @RequestParam("itemID") int itemID) {
        itemService.getItemRepo().getItems().add(shopService.buyItem(itemID));
        if (petID.isPresent()) { return "redirect:/shop/view?petID=" + petID.get(); }
        return "redirect:/shop/view";
    }
}
