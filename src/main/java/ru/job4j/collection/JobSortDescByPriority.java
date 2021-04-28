package ru.job4j.collection;

import java.util.Comparator;

public class JobSortDescByPriority implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return o2.compareTo(o1);
    }
}
