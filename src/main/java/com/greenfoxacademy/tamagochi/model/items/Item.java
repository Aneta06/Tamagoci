package com.greenfoxacademy.tamagochi.model.items;

public abstract class Item {
    private static int Id = 1;

    private int id;
    private String name;

    public Item(String name) {
        initId();
        this.name = name;
    }
    private void initId(){
        this.id = Id++;
    }
}
