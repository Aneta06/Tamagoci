package com.greenfoxacademy.tamagochi.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {

    private static List<String> names;
    private static List<String> descriptions;

    static {
        names = new ArrayList<>();
        names.add("Buddy");
        names.add("Daisy");
        names.add("Max");
        names.add("Lucy");
        names.add("Charlie");
        names.add("Luna");
        names.add("Bailey");
        names.add("Bella");
        names.add("Rocky");
        names.add("Oliver");
        names.add("Molly");
        names.add("Tucker");
        names.add("Lola");
        names.add("Teddy");
        names.add("Sadie");
        names.add("Coco");
        names.add("Zeus");
        names.add("Roxy");
        names.add("Leo");
        names.add("Zoe");

        descriptions = new ArrayList<>();
        descriptions.add("A friendly and playful companion.");
        descriptions.add("Loves to cuddle and nap in the sun.");
        descriptions.add("A loyal and protective friend.");
        descriptions.add("Affectionate and great with kids.");
        descriptions.add("A bit shy but warms up quickly.");
        descriptions.add("Curious and inquisitive by nature.");
        descriptions.add("Known for their mischievous antics.");
        descriptions.add("Gentle and easygoing.");
        descriptions.add("Highly intelligent and trainable.");
        descriptions.add("Prone to napping in unexpected places.");
        descriptions.add("Playful and full of energy.");
        descriptions.add("A true food lover, always hungry.");
        descriptions.add("Loves to be the center of attention.");
        descriptions.add("Quiet and a great listener.");
        descriptions.add("Spontaneous and unpredictable.");
    }

    public static String getRandomName() {
        return names.get(new Random().nextInt(names.size()));
    }

    public static String getRandomDescription() {
        return descriptions.get(new Random().nextInt(descriptions.size()));
    }
}
