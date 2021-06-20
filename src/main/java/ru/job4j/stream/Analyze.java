package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    /**
     * Метод вычисляет средний балл ученика по всем предметам
     * @param stream - поток объектов типа Pupil, каждый из которых содержит список предметов
     *               типа Subject с указанием названия предмета и количества баллов по предмету
     * @return - средний балл по всем предметам для ученика или значение по умолчанию
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(
                p -> p.getSubjects()
                        .stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(-1);
    }

    /**
     * Метод вычисляет средний балл ученика по всем предметам
     * @param stream - поток объектов типа Pupil, каждый из которых содержит список предметов
     *                 типа Subject с указанием названия предмета и количества баллов по предмету
     * @return - список объектов типа Tuple, каждый из которых содержит имя ученика и его средний
     * балл по всем предметам
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(
                p -> new Tuple(p.getName(), p.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .average()
                        .orElse(-1)))
                .collect(Collectors.toList());
    }

    /**
     * Метод возвращает средний балл по каждому предмету из списков
     * предметов представленных учеников
     * @param stream - поток объектов типа Pupil, каждый из которых содержит список предметов
     *                  типа Subject с указанием названия предмета и количества баллов по предмету
     * @return - список объектов типа Tuple, каждый из которых содержит название предмета
     * и его средний балл
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(
                p -> p.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(var -> new Tuple(var.getKey(), var.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Метод определяет лучшего ученика из списка путем выбора объекта с наибольшим средним баллом
     * по всем предметам
     * @param stream - поток объектов типа Pupil, каждый из которых содержит список предметов
     *                  типа Subject с указанием названия предмета и количества баллов по предмету
     * @return - объект Tuple с именем ученика с лучшим
     * средним баллом по всем предметам или значение по умолчанию
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(
                p -> new Tuple(p.getName(), p.getSubjects()
                        .stream()
                        .mapToInt(Subject::getScore)
                        .sum()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(new Tuple("", -1));
    }

    /**
     * Метод определяет предмет из списка путем выбора объекта с наибольшим средним баллом,
     * посчитанным путем сложения баллов, заработанных каждым учеником по данному предмету.
     * @param stream - поток объектов типа Pupil, каждый из которых содержит список предметов
     *                  типа Subject с указанием названия предмета и количества баллов по предмету
     * @return - объект Tuple с названием предмета с лучшим
     *          средним баллом среди учеников или значение по умолчанию
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(
                p -> p.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(var -> new Tuple(var.getKey(), var.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(new Tuple("", -1));
    }
}
