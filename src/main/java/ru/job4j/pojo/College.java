package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student newStudent = new Student();
        newStudent.setEnrolled(new Date());
        newStudent.setName("Oleg");
        newStudent.setGroup(3);

        System.out.println(newStudent.getName() + " got accepted in the group "
                + newStudent.getGroup() + " on " + newStudent.getEnrolled());
    }
}
