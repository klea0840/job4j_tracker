package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> newMap = new HashMap<>();
        newMap.put("123456@gmail.com", "Ivanov Ivan Ivanovich");
        for (String key : newMap.keySet()) {
            System.out.println("key: " + key + System.lineSeparator()
                                    + "value: " + newMap.get(key));
        }
    }
}
