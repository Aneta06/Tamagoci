package com.greenfoxacademy.tamagochi.model.items;

import lombok.Getter;


public abstract class Item {

    private static int ID = 1;

    private int id;

    private String name;
    private String imagePath;

    public Item(String name, String imagePath) {
        initId();
        this.name = name;
        this.imagePath = imagePath;
    }

    private void initId(){
        this.id = ID++;
    }

    public String getName(){
        return this.name;
    }

    public String getImagePath() {
        return this.imagePath;
    }
}
