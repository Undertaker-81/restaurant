package ru.diploma.restaurant.repository;


import ru.diploma.restaurant.model.User;

import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 15.11.2020
 */
public interface UserRepository {

    List<User> getAll();

    User createUser(User user);

    User getUser(int id);

    User getAdminByRestaurant(int idRestaurant);

    void deleteUser(int id);

    User getUserByEmail(String email);
}
