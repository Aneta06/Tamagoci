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
        Optional<Item> optItem = shopRepo.getItem(itemID, shopRepo.getShopItems());
        if (optItem.isPresent()) {
            Item ret = optItem.get();
            shopRepo.getShopItems().remove(optItem.get());
            return ret;
        }
        return null;
    }

    public void moveToCart(int itemID) {
        Optional<Item> optItem = shopRepo.getItem(itemID, shopRepo.getShopItems());
        if (optItem.isPresent()) {
            Item item = optItem.get();
            shopRepo.getTradePool().add(item);
            shopRepo.getShopItems().remove(item);
        }
    }

    public void moveFromCart(int itemID) {
        Optional<Item> optItem = shopRepo.getItem(itemID, shopRepo.getTradePool());
        if (optItem.isPresent()) {
            Item item = optItem.get();
            shopRepo.getShopItems().add(item);
            shopRepo.getTradePool().remove(item);
        }
    }
}
