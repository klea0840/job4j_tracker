package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemSortAscOrderTest {

    @Test
    public void testCompareAscOrder() {
        Item smallerItem = new Item(12, "small");
        Item biggerItem = new Item(87, "big");
        Item middleItem = new Item(53, "middle");
        List<Item> list = new ArrayList<>();
        list.add(biggerItem);
        list.add(smallerItem);
        list.add(middleItem);
        ItemSortAscOrder sortedItems = new ItemSortAscOrder();
        Collections.sort(list, sortedItems);
        assertThat(list.get(0), is(smallerItem));
        assertThat(list.get(1), is(middleItem));
        assertThat(list.get(2), is(biggerItem));
    }

    @Test
    public void testCompareDescOrder() {
        Item smallerItem = new Item(12, "small");
        Item biggerItem = new Item(87, "big");
        Item middleItem = new Item(53, "middle");
        List<Item> list = new ArrayList<>();
        list.add(middleItem);
        list.add(smallerItem);
        list.add(biggerItem);
        ItemSortDescOrder sortedItems = new ItemSortDescOrder();
        Collections.sort(list, sortedItems);
        assertThat(list.get(0), is(biggerItem));
        assertThat(list.get(1), is(middleItem));
        assertThat(list.get(2), is(smallerItem));
    }
}