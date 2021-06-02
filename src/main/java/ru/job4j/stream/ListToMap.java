package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListToMap {

    public Map<String, Student> toMap(List<Student> list) {
        Predicate<Student> containsDplt = student -> list.contains(student.getSurname());
        return list.stream().collect(
                Collectors.toMap(
                        Student::getSurname,
                        s -> {
                            if (!containsDplt.test(s)) {
                                list.add(s);
                            }
                            return s;
                        }
                ));
    }
}
