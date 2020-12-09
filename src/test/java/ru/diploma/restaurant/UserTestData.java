package ru.diploma.restaurant;



import ru.diploma.restaurant.model.Role;
import ru.diploma.restaurant.model.User;

import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 21.11.2020
 */
public class UserTestData {

    public static final int USER1_ID = 1;
    public static final int ADMIN1_ID = 2;

    public static final User user1 = new User(1, "User1", "user@yandex.ru",  "password", Role.USER);
    public static final User admin1 = new User(2, "Admin", "admin@gmail.com","admin",  Role.ADMIN);
    public static final User admin2 = new User(3, "Admin2", "admin2@gmail.com","admin", Role.ADMIN);
    public static final User admin3 = new User(4, "Admin3",  "admin3@gmail.com","admin", Role.ADMIN);
    public static final User user2 = new User(5, "User2",  "user2@yandex.ru", "password",Role.USER);
    public static final User user3 = new User(6, "User3",  "user3@yandex.ru","password", Role.USER);
    public static final User user4 = new User(7, "User4",  "user4@yandex.ru","password", Role.USER);
    public static final User user5 = new User(8, "User5",  "user5@yandex.ru", "password",Role.USER);
    public static final User user6 = new User(9, "User6",  "user6@yandex.ru","password", Role.USER);
    public static final User user7 = new User(10, "User7",  "user7@yandex.ru","password", Role.USER);

    public static final List<User> users = List.of(user1,admin1,admin2,admin3,user2,user3,user4,user5,user6,user7);

    public static User getNew(){
        return new User("New User",  "newuser@yandex.ru", "password",Role.USER);
    }
}