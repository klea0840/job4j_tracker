package ru.job4j.collection;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    /**
     * @param o1  - String for comparison
     * @param o2- String for comparison
     * @return - result of comparison
     */
    @Override
    public int compare(String o1, String o2) {
        String[] stringO1 = o1.split("/");
        String[] stringO2 = o2.split("/");
        if (stringO2[0].compareTo(stringO1[0]) == 0) {
            return Arrays.compare(stringO1, stringO2, Comparator.naturalOrder());
        }
        return Arrays.compare(stringO1, stringO2, Comparator.reverseOrder());
    }
}