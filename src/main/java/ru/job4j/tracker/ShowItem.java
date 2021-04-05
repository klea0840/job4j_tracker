package ru.job4j.tracker;

public class ShowItem implements UserAction {
    @Override
    public String name() {
        return "Show item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Show item ====");
        Item[] newItem = tracker.findAll();
        for (Item i
                : newItem) {
            System.out.println(i);
        }
        return true;
    }
}
