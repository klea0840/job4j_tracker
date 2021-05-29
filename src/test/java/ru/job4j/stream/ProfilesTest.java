package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void testCollect() {
        Profile client1 = new Profile(new Address("Moscow", "Val", 23, 222));
        Profile client2 = new Profile(new Address("NY", "Avenue", 87, 52));
        List<Profile> profilesList = List.of(client1, client2);
        Profiles newProfiles = new Profiles();
        List<Address> rsl = newProfiles.collect(profilesList);
        List<Address> expected = new ArrayList<>();
        expected.add(client1.getAddress());
        expected.add(client2.getAddress());
        assertThat(rsl, is(expected));
    }
}