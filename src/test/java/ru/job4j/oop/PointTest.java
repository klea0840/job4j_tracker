package ru.job4j.oop;

import junit.framework.TestCase;
import org.junit.Assert;

public class PointTest extends TestCase {

    public void testDistance3d() {

        Point first = new Point(1, 1, 1);
        Point second = new Point(2, 2, 3);
        double rsl = first.distance3d(second);
        Assert.assertEquals(2.45,rsl, 0.01);
    }
}