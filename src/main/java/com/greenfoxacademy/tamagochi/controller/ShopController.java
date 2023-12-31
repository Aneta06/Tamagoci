package com.greenfoxacademy.tamagochi.controller;

import com.greenfoxacademy.tamagochi.model.items.Item;
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
        model.addAttribute("tradePool", shopService.getShopRepo().getTradePool());
        return "viewShop";
    }

    @PostMapping("/shop/toCart")
    public String moveToCart(Model model,
                             @RequestParam("petID") Optional<Integer> petID,
                             @RequestParam("itemID") int itemID) {

        shopService.moveToCart(itemID);
        if (petID.isPresent()) { return "redirect:/shop/view?petID=" + petID.get(); }
        return "redirect:/shop/view";
    }

    @PostMapping("/shop/fromCart")
    public String moveFromCart(Model model,
                               @RequestParam("petID") Optional<Integer> petID,
                               @RequestParam("itemID") int itemID) {

        shopService.moveFromCart(itemID);
        if (petID.isPresent()) { return "redirect:/shop/view?petID=" + petID.get(); }
        return "redirect:/shop/view";
    }

    @PostMapping("/shop/buyItems")
    public String buyItems(@RequestParam("petID") Optional<Integer> petID) {
        for (Item i : shopService.getShopRepo().getTradePool()) {
            itemService.getItemRepo().getItems().add(i);
            i = null;
        }
        shopService.getShopRepo().getTradePool().clear();
        if (petID.isPresent()) {
            return "redirect:/shop/view?petID=" + petID.get();
        }
        return "redirect:/shop/view";
    }

    @PostMapping("/shop/clearCart")
    public String clearCart(@RequestParam("petID") Optional<Integer> petID) {
        for (Item i : shopService.getShopRepo().getTradePool()) {
            shopService.getShopRepo().getShopItems().add(i);
            i = null;
        }
        shopService.getShopRepo().getTradePool().clear();
        if (petID.isPresent()) {
            return "redirect:/shop/view?petID=" + petID.get();
        }
        return "redirect:/shop/view";
    }
}
