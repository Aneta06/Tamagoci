package com.greenfoxacademy.tamagochi.model.items;

import java.util.ArrayList;
import java.util.List;

public enum FoodType {
        SAUSAGE, MEAT, APPLE;

    public static List<String> getTypes(){
        List<String> record = new ArrayList<>();
        for (FoodType t : FoodType.values()){
            record.add(t.toString());
        }
        return record;
    }
}
