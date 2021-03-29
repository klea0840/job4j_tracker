package ru.job4j.oop;

public class Dentist extends Doctor {

    private int removedTeeth;
    private String clinic;
    private int freeClinic;

    public String getClinic(String s) {
        return clinic + s;
    }
}
