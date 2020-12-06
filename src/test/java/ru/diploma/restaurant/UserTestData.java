package ru.diploma.restaurant;

import static ru.diploma.restaurant.model.Restaurant.START_SEQ;

import ru.diploma.restaurant.model.Role;
import ru.diploma.restaurant.model.User;

import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 21.11.2020
 */
public class UserTestData {
    public static final int USER1_ID = START_SEQ;
    public static final int ADMIN1_ID = START_SEQ+1;

    public static final User user1 = new User(START_SEQ, "User1", Role.USER, "password", "user@yandex.ru");
    public static final User admin1 = new User(START_SEQ + 1, "Admin", Role.ADMIN, "admin", "admin@gmail.com");
    public static final User admin2 = new User(START_SEQ + 2, "Admin2", Role.ADMIN, "admin", "admin2@gmail.com");
    public static final User admin3 = new User(START_SEQ + 3, "Admin3", Role.ADMIN, "admin", "admin3@gmail.com");
    public static final User user2 = new User(START_SEQ + 4, "User2", Role.USER, "password", "user2@yandex.ru");
    public static final User user3 = new User(START_SEQ + 5, "User3", Role.USER, "password", "user3@yandex.ru");
    public static final User user4 = new User(START_SEQ + 6, "User4", Role.USER, "password", "user4@yandex.ru");
    public static final User user5 = new User(START_SEQ + 7, "User5", Role.USER, "password", "user5@yandex.ru");
    public static final User user6 = new User(START_SEQ + 8, "User6", Role.USER, "password", "user6@yandex.ru");
    public static final User user7 = new User(START_SEQ + 9, "User7", Role.USER, "password", "user7@yandex.ru");

    public static final List<User> users = List.of(user1,admin1,admin2,admin3,user2,user3,user4,user5,user6,user7);

    public static User getNew(){
        return new User("New User", Role.USER, "newuser@yandex.ru", "password");
    }
}
