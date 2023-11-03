package com.greenfoxacademy.tamagochi.model.items;

import java.util.ArrayList;
import java.util.List;

public enum ToyType {

    BONE, BALL, SOFT_TOY;

    public static List<String> getTypes(){
        List<String> record = new ArrayList<>();
        for (ToyType t : ToyType.values()){
            record.add(t.toString());
        }
        return record;
    }
}
