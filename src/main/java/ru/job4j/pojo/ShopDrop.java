package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        for (int i = index; i < products.length; i++) {
            products[i] = products[products.length - i - 1];
            products[products.length - 1] = null;
        }
        return products;
    }
}
