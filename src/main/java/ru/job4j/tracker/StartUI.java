package ru.job4j.tracker;

import java.util.Scanner;

import static java.util.Objects.isNull;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show item ====");
                Item[] newItem = tracker.findAll();
                for (Item i
                        : newItem) {
                    System.out.println(i.toString());
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.print("Enter id: ");
                int numId = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter the name of the new application: ");
                String nameApl = scanner.nextLine();
                Item item = new Item(nameApl);
                tracker.replace(numId, item);
                if (tracker.replace(numId, item)) {
                    System.out.println("Mission accomplished");
                } else {
                    System.out.println("Id not found");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.print("Enter id: ");
                int numId = Integer.parseInt(scanner.nextLine());
                boolean del = tracker.delete(numId);
                if (del) {
                    System.out.println("Mission accomplished");
                } else {
                    System.out.println("Id not found");
                }
            } else if (select == 4) {
                System.out.println("=== Find by id ====");
                System.out.print("Enter id: ");
                int numId = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(numId);
                if (!isNull(item)) {
                    System.out.println("Mission accomplished : " + item.toString());
                } else {
                    System.out.println("Id not found");
                }
            } else if (select == 5) {
                System.out.println("=== Find by name ====");
                System.out.print("Enter the name for search: ");
                String nameSearch = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
        int select = Integer.valueOf(scanner.nextLine());

    }
}
