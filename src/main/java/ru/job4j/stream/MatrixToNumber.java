package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class MatrixToNumber {
    public List<Integer> switchToList(List<List<Integer>> list) {
        return list.stream().flatMap(e -> e.stream()).collect(Collectors.toList());
    }
}
