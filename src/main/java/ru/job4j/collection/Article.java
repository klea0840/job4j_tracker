package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class Article {
    public static boolean generateBy(String origin, String line) {
        try {
            HashSet<String> original = new HashSet<>(Arrays.asList(
                    origin.split("[.,!?:; ]"))
            );
            HashSet<String> actualLine = new HashSet<>(Arrays.asList(
                    line.split("[.,!?:; ]"))
            );
            if (original.containsAll(actualLine)) {
                return true;
            }
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        return false;
    }
}
