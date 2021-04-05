package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        int numId = input.askInt("Enter id: ");
        boolean del = tracker.delete(numId);
        if (del) {
            System.out.println("Mission accomplished");
        } else {
            System.out.println("Id not found");
        }
        return true;
    }
}
