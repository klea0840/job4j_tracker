package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker1 = new Tracker();
        Item item1 = new Item();
        tracker1.add(item1);
        System.out.println(tracker1.findById(item1.getId()));
    }
}
