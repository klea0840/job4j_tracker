package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> source;

    private EasyStream(List<Integer> source) {
        this.source = source;
        }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> list = new ArrayList<>();
        for (Integer i: this.source) {
             list.add(fun.apply(i));
        }
        return new EasyStream(list);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> list = new ArrayList<>();
        for (Integer i: this.source) {
            if (fun.test(i)) {
                list.add(i);
            }
        }
        return new EasyStream(list);
    }

    public List<Integer> collect() {
        return new ArrayList<>(this.source);
    }
}
