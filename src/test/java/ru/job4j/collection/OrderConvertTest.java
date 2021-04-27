package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenDubOrderBySize() {
        List<Order> orders = new ArrayList<>();
        Order newOrder = new Order("3sfe", "Dress");
        orders.add(newOrder);
        orders.add(newOrder);
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.size(), is(1));
    }

    @Test
    public void whenDubleOrderByValue() {
        List<Order> orders = new ArrayList<>();
        Order newOrder = new Order("3sfe", "Dress");
        Order newOrderNext = new Order("3sfe", "Pants");
        orders.add(newOrder);
        orders.add(newOrderNext);
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(newOrderNext));
    }
}