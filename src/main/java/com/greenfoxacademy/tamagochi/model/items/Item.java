package com.greenfoxacademy.tamagochi.model.items;

public abstract class Item {
    private static int ID = 1;

    private int id;
    private String name;
    private String imagePath;

    public Item(String name, String imagePath) {
        initId();
        this.name = name;
    }
    private void initId(){
        this.id = ID++;
    }
}
