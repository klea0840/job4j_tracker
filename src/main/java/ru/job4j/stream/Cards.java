package ru.job4j.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cards {

    private Suit suit;
    private Value value;

    public Cards(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {

        Stream.of(Suit.values())
                .flatMap(suit1 -> Stream.of(Value.values())
                        .map(value1 -> new Cards(suit1, value1)))
                .collect(Collectors.toList());
    }
}
