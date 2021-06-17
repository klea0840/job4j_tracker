package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;

import static java.util.Objects.isNull;

public class FreezeStr {
    /**
     * Метод принимает 2 строки и проверяет, получена ли вторая строка
     * путем перестановки символов первой.
     * @param left- первая строка для проверки (референтная)
     * @param right - вторая строка для проверки (проверяемая)
     * @return - true/false
     */
    public static boolean eq(String left, String right) {
        char[] leftString = left.toCharArray();
        char[] rightString = right.toCharArray();
        HashMap<Character, Integer> leftStringMap = new HashMap<>();
        for (Character ch : leftString) {
            Integer count = leftStringMap.get(ch);
            if (isNull(count)) {
                count = 0;
            }
            leftStringMap.put(ch, count + 1);
        }
        for (char c: rightString) {
            Integer value = leftStringMap.get(c);
            if (!leftStringMap.containsKey(c)) {
                return false;
            } else if (value == 1) {
                leftStringMap.remove(c, value);
            } else if (value > 1) {
                leftStringMap.put(c, value - 1);
            }
        }
        return leftStringMap.isEmpty();
    }
}
