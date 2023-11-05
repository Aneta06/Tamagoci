package com.greenfoxacademy.tamagochi.service;

import com.greenfoxacademy.tamagochi.model.items.Item;
import com.greenfoxacademy.tamagochi.repository.ShopRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShopService {

    private final ShopRepo shopRepo;

    public ShopService(ShopRepo shopRepo) {
        this.shopRepo = shopRepo;
    }

    public ShopRepo getShopRepo() { return this.shopRepo; }

    public Item buyItem(int itemID) {
        Optional<Item> optItem = shopRepo.getItem(itemID);
        if (optItem.isPresent()) {
            Item ret = optItem.get();
            shopRepo.getShopItems().remove(optItem.get());
            return ret;
        }
        return null;
    }
}
