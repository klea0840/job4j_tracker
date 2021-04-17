package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    private final Output out;

    public DeleteItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete item ====");
        int numId = input.askInt("Enter id: ");
        boolean del = tracker.delete(numId);
        if (del) {
            out.println("Mission accomplished");
        } else {
            out.println("Id not found");
        }
        return true;
    }
}
