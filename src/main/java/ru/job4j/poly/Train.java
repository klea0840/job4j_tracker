package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName()
                + ": Sheldon Cooper can explain how trains move");
    }
}
