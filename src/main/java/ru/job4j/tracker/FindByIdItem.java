package ru.job4j.tracker;

import static java.util.Objects.isNull;

public class FindByIdItem implements UserAction {
    private final Output out;

    public FindByIdItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find by id ====");
        int numId = input.askInt("Enter id: ");
        Item item = tracker.findById(numId);
        if (!isNull(item)) {
            out.println("Mission accomplished : " + item);
        } else {
            out.println("Id not found");
        }
        return true;
    }
}
