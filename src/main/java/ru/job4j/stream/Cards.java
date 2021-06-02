package ru.job4j.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cards {

    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8
    }

    private Suit suit;
    private Value value;

    public Cards(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Suit[] suits = {Suit.Diamonds, Suit.Hearts, Suit.Spades, Suit.Clubs};
        Value[] values = {Value.V_6, Value.V_7, Value.V_8, Value.V_8};
        Stream.of(suits)
                .flatMap(suit1 -> Stream.of(values)
                        .map(value1 -> new Cards(suit1, value1)))
                .collect(Collectors.toList());
    }
}
