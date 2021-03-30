package ru.job4j.oop;

import ru.job4j.tracker.Item;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item date = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentData = date.getCreated().format(formatter);
        System.out.println("current date and time: " + currentData);
    }
}
