package ru.job4j.oop;

public class Max {
    public static int max(int left, int right) {
        return Math.max(left, right);
    }

    public static int max(int left, int right, int middle) {
        return max(left, max(right, middle));
    }

    public static int max(int left, int right, int middle, int fourth) {
        return max(left, max(right, middle, fourth));
    }
}
