package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        int numId = input.askInt("Enter id: ");
        String nameApl = input.askStr("Enter the name of the new application: ");
        Item item = new Item(nameApl);
        if (tracker.replace(numId, item)) {
            System.out.println("Mission accomplished");
        } else {
            System.out.println("Id not found");
        }
        return true;
    }
}
