package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
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
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> newItems = new ArrayList<>() { };
        for (Item name : items) {
            if (name.getName().equals(key)) {
                newItems.add(name);
            }
        }
        return newItems;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
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
            items.set(index, x);
            rsl = true;
        }
        return rsl;
    }

    public boolean delete(int id) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
            rsl = true;
        }
        return rsl;
    }
}