package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<>());
        }
    }

    public void addAccount(String passport, Account account) {
        User userAdd = findByPassport(passport);

    }

    public User findByPassport(String passport) {
        User foundByPassport = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                foundByPassport = user;
            }
        }
        return foundByPassport;
    }

    public Account findByRequisite(String passport, String requisite) {
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        return rsl;
    }
}
