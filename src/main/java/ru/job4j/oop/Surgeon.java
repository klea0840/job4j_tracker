package ru.job4j.oop;

public class Surgeon extends Doctor {

    private int numOperations;
    private double survivalRate;
    private String hospital;

    public int getNumOperations() {
        return numOperations;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
}
