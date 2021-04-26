package ru.job4j.bank;

import java.util.*;

import static java.util.Objects.isNull;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        List<Account> accounts = users.get(findByPassport(passport));
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
    }

    public User findByPassport(String passport) {
        User foundUser = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                foundUser = user;
            }
        }
        return foundUser;
    }

    public Account findByRequisite(String passport, String requisite) {
        List<Account> accounts = users.get(findByPassport(passport));
        if (isNull(accounts)) {
            return null;
        } else {
            int foundIndex = accounts.indexOf(new Account(requisite, -1));
            if (foundIndex == -1) {
                return null;
            }
            return accounts.get(foundIndex);
        }
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        double result = srcAccount.getBalance() - amount;
        double destResult = destAccount.getBalance() + amount;
        if (!isNull(srcAccount) && !isNull(destAccount) && (result >= 0)) {
            destAccount.setBalance(destResult);
            srcAccount.setBalance(result);
            rsl = true;
        }
        return rsl;
    }
}
