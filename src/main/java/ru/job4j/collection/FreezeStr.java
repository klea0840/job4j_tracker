package ru.job4j.collection;

import java.util.HashMap;

import static java.util.Objects.isNull;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        char[] leftString = left.toCharArray();
        char[] rightString = right.toCharArray();
        HashMap<Character, Integer> leftStringMap = new HashMap<>();
        for (Character ch : leftString) {
            Integer count = leftStringMap.get(ch);
            if (isNull(count)) {
                count = 0;
            }
            leftStringMap.put(ch, ++count);
        }
        HashMap<Character, Integer> rightStringMap = new HashMap<>();
        for (Character ch : rightString) {
            Integer count = rightStringMap.get(ch);
            if (isNull(count)) {
                count = 0;
            }
            rightStringMap.put(ch, ++count);
        }
        if (rightStringMap.size() != leftStringMap.size()) {
            return false;
        } else {
            for (var v: leftStringMap.keySet()) {
                if ((!rightStringMap.containsKey(v))
                        || (rightStringMap.get(v) != (leftStringMap.get(v)))) {
                    return false;
                }
            }
        }
        return true;
    }
}
