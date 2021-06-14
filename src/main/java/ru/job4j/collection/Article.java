package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class Article {
    public static boolean generateBy(String origin, String line) {
            HashSet<String> original = new HashSet<>(Arrays.asList(
                    origin.split("[.,!?:; ]"))
            );
            String[] actualLine = line.split("[.,!?:; ]");
        for (String s : actualLine) {
            if (!original.contains(s)) {
                return false;
            }
        }
        return true;
    }
}
