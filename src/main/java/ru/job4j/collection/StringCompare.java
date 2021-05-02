package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] leftChar = left.toCharArray();
        char[] rightChar = right.toCharArray();
        int size = Integer.compare(leftChar.length, rightChar.length);
        int rsl = 0;
        for (int i = 0; i < Math.min(leftChar.length - 1, rightChar.length - 1); i++) {
                rsl = Character.compare(leftChar[i], rightChar[i]);
                if (rsl != 0) {
                    break;
                }

            }
        if (rsl == 0) {
            return Integer.compare(leftChar.length, rightChar.length);
        }
        return rsl;
    }
}
