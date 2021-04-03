package ru.job4j.tracker;

import static java.util.Objects.isNull;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String msg = "Enter name: ";
                String name = input.askStr(msg);
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show item ====");
                Item[] newItem = tracker.findAll();
                for (Item i
                        : newItem) {
                    System.out.println(i);
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                int numId = input.askInt("Enter id: ");
                String nameApl = input.askStr("Enter the name of the new application: ");
                Item item = new Item(nameApl);
                if (tracker.replace(numId, item)) {
                    System.out.println("Mission accomplished");
                } else {
                    System.out.println("Id not found");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                int numId = input.askInt("Enter id: ");
                boolean del = tracker.delete(numId);
                if (del) {
                    System.out.println("Mission accomplished");
                } else {
                    System.out.println("Id not found");
                }
            } else if (select == 4) {
                System.out.println("=== Find by id ====");
                int numId = input.askInt("Enter id: ");
                Item item = tracker.findById(numId);
                if (!isNull(item)) {
                    System.out.println("Mission accomplished : " + item);
                } else {
                    System.out.println("Id not found");
                }
            } else if (select == 5) {
                System.out.println("=== Find by name ====");
                String nameSearch = input.askStr("Enter the name for search: ");
                Item[] foundItems = tracker.findByName(nameSearch);
                if (foundItems.length > 0) {
                    for (int i = 0; i < foundItems.length; i++) {
                        System.out.println(foundItems[i]);
                    }
                } else {
                    System.out.println("Applications with this name not found");
                }
            } else if (select == 6) {
                run = false;
                System.out.println("Exit");
            } else {
                System.out.println("Wrong input. Try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
