package ru.job4j.pojo;

import static java.util.Objects.isNull;

public class Shop {
    public static int indexOfNull(Product[] products) {
        int index = -1;
        for (int i = 0; i < products.length; i++) {
            if (isNull(products[i])) {
                index = i;
               break;
            }
        }
        return index;
    }
}
