package com.greenfoxacademy.tamagochi.service;

import com.greenfoxacademy.tamagochi.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {


    private final ItemRepo items;

    public ItemService(ItemRepo items) {
        this.items = items;
    }

    public ItemRepo getItemRepo() { return items; }
}
