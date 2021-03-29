package ru.job4j.oop;

public class Engineer extends Profession {

    private int projects;
    private int budget;
    private boolean elonMusk;

    public int calculate(int cost) {
        return budget - cost;
    }
}
