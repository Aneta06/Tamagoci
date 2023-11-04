package com.greenfoxacademy.tamagochi.repository;

import com.greenfoxacademy.tamagochi.model.items.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepo {

    private List<Item> items;

    public ItemRepo() {
        this.items = new ArrayList<>(10);
        items.add(new Bone());
        items.add(new Ball());
        items.add(new SoftToy());
        items.add(new Apple());
        items.add(new Meat());
        items.add(new Sausage());
        items.add(new Brush());
        items.add(new Sponge());
        items.add(new Apple());
        items.add(new Ball());
    }
    public List<Item> getItems() { return items; }
}
