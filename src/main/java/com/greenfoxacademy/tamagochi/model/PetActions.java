package com.greenfoxacademy.tamagochi.model;

public interface PetActions {

    public void eat(Edible edible);
    public void play(Entertaining entertaining);
    public void sleep();
    public void clean(Washing washing);
    public String greet();

}
