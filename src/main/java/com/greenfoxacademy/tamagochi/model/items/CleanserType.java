package com.greenfoxacademy.tamagochi.model.items;

import java.util.ArrayList;
import java.util.List;

public enum CleanserType {

    SPONGE, BRUSH;

    public static List<String> getTypes(){
        List<String> record = new ArrayList<>();
        for (CleanserType t : CleanserType.values()){
            record.add(t.toString());
        }
        return record;
    }
}
