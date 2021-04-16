//package ru.job4j.tracker;
//
//public class FindByNameItem implements UserAction {
//    private final Output out;
//
//    public FindByNameItem(Output out) {
//        this.out = out;
//    }
//
//    @Override
//    public String name() {
//        return "Find by name";
//    }
//
//    @Override
//    public boolean execute(Input input, Tracker tracker) {
//        out.println("=== Find by name ====");
//        String nameSearch = input.askStr("Enter the name for search: ");
//        Item[] foundItems = tracker.findByName(nameSearch);
//        if (foundItems.length > 0) {
//            for (int i = 0; i < foundItems.length; i++) {
//                out.println(foundItems[i]);
//            }
//        } else {
//            out.println("Applications with this name not found");
//        }
//        return true;
//    }
//}
