package ru.job4j.tracker;

public class ShowItem implements UserAction {
    private final Output out;

    public ShowItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show item ====");
        Item[] newItem = tracker.findAll();
        for (Item i
                : newItem) {
            out.println(i);
        }
        return true;
    }
}
