package ru.job4j.stream;

import java.util.Comparator;
import java.util.Objects;

public class Address {
    private String city;

    private String street;

    private int home;

    private int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.apartment = apartment;
        this.home = home;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return city.equals(address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city);
    }
}
