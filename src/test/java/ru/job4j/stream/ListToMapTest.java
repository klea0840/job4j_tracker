package ru.job4j.stream;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListToMapTest {
    @Test
    public void testToMap() {
        Student student1 = new Student(10, "Surname1");
        Student student2 = new Student(40, "Surname4");
        Student student3 = new Student(50, "Surname5");
        Student student4 = new Student(50, "Surname5");
        List<Student> students = List.of(
                student1, student2, student3, student4
        );
        ListToMap newMap = new ListToMap();
        Map<String, Student> rsl = newMap.toMap(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Surname1", student1);
        expected.put("Surname4", student2);
        expected.put("Surname5", student3);
        assertThat(rsl, is(expected));
    }

    @Test
    public void testToMap2() {
        Student student1 = new Student(0, "");
        Student student2 = new Student(40, "Surname4");
        Student student3 = new Student(50, "Surname5");
        Student student5 = new Student(60, "Surname7");
        Student student4 = new Student(50, "Surname5");
        List<Student> students = List.of(
                student1, student2, student3, student4, student5
        );
        ListToMap newMap = new ListToMap();
        Map<String, Student> rsl = newMap.toMap(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("", student1);
        expected.put("Surname4", student2);
        expected.put("Surname5", student3);
        expected.put("Surname7", student5);
        assertThat(rsl, is(expected));
    }
}