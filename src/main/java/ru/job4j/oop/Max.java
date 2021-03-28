package ru.job4j.oop;

public class Max {
    public static int max(int left, int right) {
        return left > right ? left : right;
    }

    public static int max(int left, int right, int middle) {
        if (left > right && left > middle) {
            return left;
        } else if (right > left && right > middle) {
            return right;
        } else {
            return middle;
        }
    }

    public static int max(int left, int right, int middle, int fourth) {
        int[] array = {left, right, middle, fourth};
        for (int i = 1; i < array.length; i++) {
            if (array[0] < array[i]) {
                array[0] = array[i];
            }
        }
        return array[0];
    }
}
