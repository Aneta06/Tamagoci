package com.greenfoxacademy.tamagochi.service;

import com.greenfoxacademy.tamagochi.model.items.Item;
import com.greenfoxacademy.tamagochi.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {


    @Autowired
    private ItemRepo items;

    public List<Item> getItems() { return items.getItems(); }
}
