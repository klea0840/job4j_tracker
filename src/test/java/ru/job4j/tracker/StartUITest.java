package ru.job4j.tracker;

import junit.framework.TestCase;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void testCreate3Item() {
        String[] answers = {"Fix PC", "Item2", "25"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        StartUI.createItem(input, tracker);
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[1];
        Item expected = new Item("Item2");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void testEditItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        Item item2 = new Item("news item");
        tracker.add(item);
        tracker.add(item2);
        String[] answers = {
                String.valueOf(item2.getId()), /* id сохраненной заявки в объект tracker. */
                item.getName() /* id сохраненной заявки в объект tracker. */
        };
        StartUI.editItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item2.getId());
        assertThat(replaced.getName(), is(item.getName()));
    }

    @Test
    public void testDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        Item newIitem = new Item("news item");
        tracker.add(item);
        tracker.add(newIitem);
        String[] answers = {
                String.valueOf(newIitem.getId()), /* id сохраненной заявки в объект tracker. */
        };
        StartUI.deleteItem(new StubInput(answers), tracker);
        Item deleted = tracker.findById(newIitem.getId());
        assertNull(deleted);
    }
}