package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(-20);
        numbers.add(-7);
        numbers.add(450);
        numbers.add(0);
        numbers.add(64);
        numbers.add(9);
        numbers.add(10);

        List<Integer> sortedNumbers = numbers.stream().filter(
                num -> num > 0
        ).collect(Collectors.toList());
        sortedNumbers.forEach(System.out :: println);
    }
}
