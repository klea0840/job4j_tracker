package ru.job4j.ex;

import static java.util.Objects.isNull;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (User s : users) {
            if (s.getUsername().equals(login)) {
                rsl = s;
            }
        }
        if (isNull(rsl)) {
            throw new UserNotFoundException();
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.getUsername().length() < 3 || !user.isValid()) {
            throw new UserInvalidException();
        }
        return user.isValid();
    }

    public static void main(String[] args) {
        try {
            User[] users = {
                    new User("Petr Arsentev", true),
                    new User("Vova", false)
            };
            User user = findUser(users, "Vova");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException uie) {
            System.out.println("invalid user");
            uie.printStackTrace();
        } catch (UserNotFoundException unfe) {
            System.out.println("user not found ");
            unfe.printStackTrace();
        }
    }
}
