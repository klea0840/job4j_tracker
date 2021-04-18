package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void get() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizenNext = new Citizen("2f45a", "Petr Asentev");
        Citizen citizenNext2 = new Citizen("2g44a", "Pet Arsetev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        office.add(citizenNext);
        office.add(citizenNext2);
        Citizen found = office.get("2f45a");
        assertThat(found, is(citizenNext));
    }
}