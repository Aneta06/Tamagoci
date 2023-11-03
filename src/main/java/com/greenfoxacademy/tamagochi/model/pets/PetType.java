package com.greenfoxacademy.tamagochi.model.pets;

import java.util.ArrayList;
import java.util.List;

public enum PetType {

    FOX, DOG, TIGER;

    public static List<String> getType(){
        List<String> record = new ArrayList<>();
        for (PetType t : PetType.values()){
            record.add(t.toString());
        }
        return record;
    }
}
