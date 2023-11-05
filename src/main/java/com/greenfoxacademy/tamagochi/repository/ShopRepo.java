package com.greenfoxacademy.tamagochi.repository;

import com.greenfoxacademy.tamagochi.model.items.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ShopRepo {

    private List<Item> shopItems;

    public ShopRepo() {
        this.shopItems = new ArrayList<>();
        shopItems.add(new Ball());
        shopItems.add(new Brush());
        shopItems.add(new Meat());
        shopItems.add(new SoftToy());
        shopItems.add(new Sausage());
        shopItems.add(new Bone());
        shopItems.add(new Sponge());
        shopItems.add(new Apple());
        shopItems.add(new Bone());
        shopItems.add(new Brush());
        shopItems.add(new Sausage());
        shopItems.add(new Apple());
        shopItems.add(new SoftToy());
        shopItems.add(new Ball());
        shopItems.add(new Brush());
        shopItems.add(new Sponge());
        shopItems.add(new Apple());
        shopItems.add(new Meat());
        shopItems.add(new Sausage());
        shopItems.add(new Ball());
        shopItems.add(new SoftToy());
        shopItems.add(new Bone());
        shopItems.add(new Apple());
        shopItems.add(new Meat());
        shopItems.add(new Sponge());
        shopItems.add(new Brush());
        shopItems.add(new Bone());
        shopItems.add(new Ball());
        shopItems.add(new Sausage());
        shopItems.add(new SoftToy());
        shopItems.add(new Meat());
        shopItems.add(new Sponge());
        shopItems.add(new Ball());
        shopItems.add(new Brush());
        shopItems.add(new Meat());
        shopItems.add(new SoftToy());
        shopItems.add(new Sausage());
        shopItems.add(new Bone());
        shopItems.add(new Sponge());
        shopItems.add(new Apple());
        shopItems.add(new Bone());
        shopItems.add(new Brush());
        shopItems.add(new Sausage());
        shopItems.add(new Apple());
        shopItems.add(new SoftToy());
        shopItems.add(new Ball());
        shopItems.add(new Brush());
        shopItems.add(new Sponge());
        shopItems.add(new Apple());
        shopItems.add(new Meat());
        shopItems.add(new Sausage());
        shopItems.add(new Ball());
        shopItems.add(new SoftToy());
        shopItems.add(new Bone());
        shopItems.add(new Apple());
        shopItems.add(new Meat());
        shopItems.add(new Sponge());
        shopItems.add(new Brush());
        shopItems.add(new Bone());
        shopItems.add(new Sausage());
        shopItems.add(new SoftToy());
        shopItems.add(new Meat());
        shopItems.add(new Sponge());
        shopItems.add(new Ball());
    }

    public List<Item> getShopItems() { return this.shopItems; }

    public Optional<Item> getItem(int itemID) {
        return shopItems.stream()
                .filter(i -> i.getID() == itemID)
                .findFirst();
    }
}
