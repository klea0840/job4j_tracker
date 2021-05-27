package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(-20, -7, 450, 0, 64, 9, 10));
        List<Integer> sortedNumbers = numbers.stream().filter(
                num -> num > 0
        ).collect(Collectors.toList());
//        sortedNumbers.forEach(System.out::println);
    }
}
