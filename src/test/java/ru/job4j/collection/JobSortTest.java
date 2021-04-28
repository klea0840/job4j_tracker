package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JobSortTest {
    @Test
    public void whenTestJobSortAscByName() {
        Comparator<Job> cmpAscByName = new JobSortAscByName();
        int rsl = cmpAscByName.compare(
                new Job("First", 1),
                new Job("Second", 2));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenTestJobSortAscByPriority() {
        Comparator<Job> cmpAscByPriority = new JobSortAscByPriority();
        int rsl = cmpAscByPriority.compare(
                new Job("First", 10),
                new Job("Second", 2));
        assertThat(rsl, is(1));
    }

    @Test
    public void whenTestJobSortDescByName() {
        Comparator<Job> cmpDescByName = new JobSortDescByName();
        int rsl = cmpDescByName.compare(
                new Job("First", 1),
                new Job("Second", 2));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenTestJobSortDescByPriority() {
        Comparator<Job> cmpDescByPriority = new JobSortDescByPriority();
        int rsl = cmpDescByPriority.compare(
                new Job("First", 10),
                new Job("Second", 2));
        assertThat(rsl, is(-1));
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobSortDescByName().thenComparing(new JobSortDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorAscByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobSortAscByName().thenComparing(new JobSortAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}
