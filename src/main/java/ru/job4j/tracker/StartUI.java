package ru.job4j.tracker;

import static java.util.Objects.isNull;

public class StartUI {
        public void init(Input input, Tracker tracker, UserAction[] actions) {
            boolean run = true;
            while (run) {
                this.showMenu(actions);
                int select = input.askInt("Select: ");
                UserAction action = actions[select];
                run = action.execute(input, tracker);
            }
        }

        private void showMenu(UserAction[] actions) {
            System.out.println("Menu.");
            for (int index = 0; index < actions.length; index++) {
                System.out.println(index + ". " + actions[index].name());
            }
        }

        public static void main(String[] args) {
            Input input = new ConsoleInput();
            Tracker tracker = new Tracker();
            UserAction[] actions = {
                    new CreateAction(), new ShowItem(), new ReplaceAction(),
                    new DeleteItem(), new FindByIdItem(), new FindByNameItem(),
                    new ExitItem()
            };
            new StartUI().init(input, tracker, actions);
        }
    }
//
//    public static void createItem(Input input, Tracker tracker) {
//        System.out.println("=== Create a new Item ====");
//        String name = input.askStr("Enter name: ");
//        Item item = new Item(name);
//        tracker.add(item);
//    }
//
//    public static void showItem(Input input, Tracker tracker) {
//        System.out.println("=== Show item ====");
//        Item[] newItem = tracker.findAll();
//        for (Item i
//                : newItem) {
//            System.out.println(i);
//        }
//    }
//
//    public static void editItem(Input input, Tracker tracker) {
//        System.out.println("=== Edit item ====");
//        int numId = input.askInt("Enter id: ");
//        String nameApl = input.askStr("Enter the name of the new application: ");
//        Item item = new Item(nameApl);
//        if (tracker.replace(numId, item)) {
//            System.out.println("Mission accomplished");
//        } else {
//            System.out.println("Id not found");
//        }
//    }
//
//    public static void deleteItem(Input input, Tracker tracker) {
//        System.out.println("=== Delete item ====");
//        int numId = input.askInt("Enter id: ");
//        boolean del = tracker.delete(numId);
//        if (del) {
//            System.out.println("Mission accomplished");
//        } else {
//            System.out.println("Id not found");
//        }
//    }
//
//    public static void findById(Input input, Tracker tracker) {
//        System.out.println("=== Find by id ====");
//        int numId = input.askInt("Enter id: ");
//        Item item = tracker.findById(numId);
//        if (!isNull(item)) {
//            System.out.println("Mission accomplished : " + item);
//        } else {
//            System.out.println("Id not found");
//        }
//    }
//
//    public static void findByName(Input input, Tracker tracker) {
//        System.out.println("=== Find by name ====");
//        String nameSearch = input.askStr("Enter the name for search: ");
//        Item[] foundItems = tracker.findByName(nameSearch);
//        if (foundItems.length > 0) {
//            for (int i = 0; i < foundItems.length; i++) {
//                System.out.println(foundItems[i]);
//            }
//        } else {
//            System.out.println("Applications with this name not found");
//        }
//    }
//
////    public static void replaceItem(Input input, Tracker tracker) {
////        System.out.println(" === Update item ====");
////        int id = input.askInt("Enter id:");
////        String name = input.askStr("Enter a new name of item: ");
////        Item item = new Item(name);
////        item.setId(id);
////        tracker.replace(id, item);
////    }
//
//    public void init(Input input, Tracker tracker) {
//        boolean run = true;
//        while (run) {
//            this.showMenu();
//            int select = input.askInt("Select: ");
//            if (select == 0) {
//                StartUI.createItem(input, tracker);
//            } else if (select == 1) {
//                StartUI.showItem(input, tracker);
//            } else if (select == 2) {
//                StartUI.editItem(input, tracker);
//            } else if (select == 3) {
//                StartUI.deleteItem(input, tracker);
//            } else if (select == 4) {
//                StartUI.findById(input, tracker);
//            } else if (select == 5) {
//               StartUI.findByName(input, tracker);
//            } else if (select == 6) {
//                run = false;
//                System.out.println("Exit");
//            } else {
//                System.out.println("Wrong input. Try again.");
//            }
//        }
//    }
//
//    private void showMenu() {
//        System.out.println("Menu.");
//        System.out.println("0. Add new item");
//        System.out.println("1. Show all items");
//        System.out.println("2. Edit item");
//        System.out.println("3. Delete item");
//        System.out.println("4. Find item by id");
//        System.out.println("5. Find items by name");
//        System.out.println("6. Exit program");
//    }
//
//    public static void main(String[] args) {
//        Input input = new ConsoleInput();
//        Tracker tracker = new Tracker();
//        new StartUI().init(input, tracker);
//    }
