package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(size++, item);
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
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> newItems = new ArrayList<>() { };
        int count = 0;
        for (int i = 0; i < size; i++) {
            Item name = items.get(i);
            if (name.getName().equals(key)) {
                newItems.add(count, name);
                count++;
            }
        }
        return newItems;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item x) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            x.setId(id);
            items.add(index, x);
            rsl = true;
        }
        return rsl;
    }

    public boolean delete(int id) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, size - index);
            items.set(size - 1, null);
            size--;
            rsl = true;
        }
        return rsl;
    }
}