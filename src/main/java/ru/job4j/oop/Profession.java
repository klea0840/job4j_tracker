package ru.job4j.oop;

public class Profession {

    private int salary;
    private int experience;
    private String education;
    private boolean phd;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public boolean isPhd() {
        return phd;
    }

    public void setPhd(boolean phd) {
        this.phd = phd;
    }
}
