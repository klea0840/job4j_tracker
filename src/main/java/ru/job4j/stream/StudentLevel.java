package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

public class StudentLevel {
    /**
     * Метод принимает список студентов и уровень проходного балла,
     * убирает null объекты и объекты с баллом ниже заданного уровня,
     * сортирует в порядке убывания
     * @param students - список студентов
     * @param bound - проходной балл
     * @return - список студентов без null объектов с сортировкой
     * в порядке убывания, прошедших по баллам
     */
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(s -> !isNull(s))
                .sorted((left, right) -> Integer.compare(right.getScore(), left.getScore()))
//                .sorted(Comparator.comparing(Student::getScore))
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}