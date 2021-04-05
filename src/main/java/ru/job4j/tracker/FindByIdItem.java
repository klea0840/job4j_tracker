package ru.job4j.tracker;

import static java.util.Objects.isNull;

public class FindByIdItem implements UserAction {
    @Override
    public String name() {
        return "Find by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find by id ====");
        int numId = input.askInt("Enter id: ");
        Item item = tracker.findById(numId);
        if (!isNull(item)) {
            System.out.println("Mission accomplished : " + item);
        } else {
            System.out.println("Id not found");
        }
        return true;
    }
}
