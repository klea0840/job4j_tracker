package ru.job4j.tracker;

import junit.framework.TestCase;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest extends TestCase {
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
}