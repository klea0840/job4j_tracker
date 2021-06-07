package ru.job4j.collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenDesOrder3() {
        List<String> input = Arrays.asList("k1", "k1/sk1", "k2", "k2/sk1", "k2/k1");
        Departments.sortDesc(input);
        assertThat(input.get(3), is("k1"));
    }

    @Test
    public void whenDesOrder4() {
        List<String> input = Arrays.asList("k1", "k1/sk1", "k2", "k2/sk1", "k2/k1");
        Departments.sortDesc(input);
        assertThat(input.get(1), is("k2/k1"));
    }

    @Test
    public void whenAcsOrder4() {
        List<String> input = Arrays.asList("k1", "k1/sk1", "k2", "k2/sk1", "k2/k1");
        Departments.sortAsc(input);
        assertThat(input.get(1), is("k1/sk1"));
    }
}