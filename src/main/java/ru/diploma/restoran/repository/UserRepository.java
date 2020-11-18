package ru.diploma.restoran.repository;


import ru.diploma.restoran.model.User;

import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 15.11.2020
 */
public interface UserRepository {

    List<User> getAll();

    User createUser(User user);

    User getUser(int id);

    User getAdminByRestoran(int id, int idRestoran);

    void deleteUser(int id);
}
