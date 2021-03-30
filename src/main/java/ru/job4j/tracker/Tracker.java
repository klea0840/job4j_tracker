package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
//        Item rsl = null;
//        for (int index = 0; index < size; index++) {
//            Item item = items[index];
//            if (item.getId() == id) {
//                rsl = item;
//                break;
//            }
//        }
//        return rsl;
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll(Item[] items) {
        Item[] newItems = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            Item name = items[i];
            if (name != null) {
                newItems[size] = name;
                size++;
            }
        }
        return Arrays.copyOf(newItems, size);
    }

    public Item[] findByName(String key) {
        Item[] newItems = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            Item name = items[i];
            if (name.getName().equals(key)) {
                newItems[size] = name;
                size++;
            }
        }
        return Arrays.copyOf(newItems, size);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item x) {
        boolean rsl = false;
        if (indexOf(id) != -1) {
            int index = indexOf(id);
            x.setId(id);
            items[index] = x;
            rsl = true;
        }
        return rsl;
    }
}