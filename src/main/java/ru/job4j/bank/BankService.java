package ru.job4j.bank;

import java.util.*;

import static java.util.Objects.isNull;

/**
 * Класс описывает работу сервиса по созданию, поиску, удалению пользователей
 * банковской системы, а также переводу денежных средств между счетами пользователей
 * @author Lali Kairova
 * @version 1.0
 */
public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает данные полльзователя и добавляет в систему
     * если пользователь еще не зарегистрирован
     * @param user - пользователь, который добавляется в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый счет после поиска пользователя по паспорту
     * и проверку, что такой счет еще не создан
     * @param passport - паспортные данные пользователя для поиска
     * @param account - новый добавляемый счет
     */
    public void addAccount(String passport, Account account) {
        Optional<User> userFound = findByPassport(passport);
        if (userFound.isPresent()) {
            List<Account> accounts = users.get(userFound.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод находит пользователя по паспорту
     * @param passport- паспортные данные пользователя для поиска
     * @return возвращает пользователя или null, если пользователь не найден
     */
    public Optional<User> findByPassport(String passport) {
        Optional<User> user = Optional.empty();
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод находит счет пользователя по реквизитам
     * @param passport - паспортные данные пользователя для поиска
     * @param requisite - реквизиты счета пользователя
     * @return возвращает счет пользователя или null, если счет отсутствует
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
    }

    /**
     * Метод осущетсвляет перевод заданной суммы денежных средств со
     * счета одного пользователя на счет другого пользователя
     * @param srcPassport - паспортные данные пользователя - отправителя
     * @param srcRequisite - счет, с которого отправляются средства
     * @param destPassport - паспортные данные пользователя - получателя
     * @param destRequisite - счет, на который переводятся средства
     * @param amount - сумма перевода
     * @return возвращает true в случае успешного перевода
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()) {
            double result = srcAccount.get().getBalance() - amount;
            double destResult = destAccount.get().getBalance() + amount;
            if (result >= 0) {
                destAccount.get().setBalance(destResult);
                srcAccount.get().setBalance(result);
                rsl = true;
            }
        }
        return rsl;
    }
}
