package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {

    public Map<String, Student> toMap(List<Student> list) {
        return list.stream().collect(
                Collectors.toMap(
                        Student::getSurname,
                        s -> s,
                        (element, dublicate) -> {
                            if (!element.equals(dublicate)) {
                                list.add(element);
                            }
                            return element;
                        }
                ));
    }
}
