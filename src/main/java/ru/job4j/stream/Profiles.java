package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
        public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(
                Profile::getAddress
        ).collect(Collectors.toList());
    }

    public List<Address> collectNoRep(List<Profile> profiles) {
        return profiles.stream().map(
                Profile::getAddress
        )
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Address> collectSorted(List<Profile> profiles) {
        return profiles.stream().map(
                Profile::getAddress
        )
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
