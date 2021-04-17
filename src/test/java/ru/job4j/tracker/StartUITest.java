package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitItem());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Added item"));
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", item.getName(), "1"}
        );
                List<UserAction> actions = new ArrayList<>();
                actions.add(new FindByNameItem(out));
                actions.add(new ExitItem());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find by name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Find by name ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator() +
                        "0. Find by name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Added item"));
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdItem(out));
        actions.add(new ExitItem());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find by id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Find by id ====" + System.lineSeparator()
                        + "Mission accomplished : " + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator() +
                        "0. Find by id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenShowItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Added item"));
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowItem(out));
        actions.add(new ExitItem());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Show item" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Show item ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator() +
                        "0. Show item" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"10", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitItem());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit" + ln
                )
        );
    }
}