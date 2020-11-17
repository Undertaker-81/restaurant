package ru.diploma.restoran.repository;


import ru.diploma.restoran.model.User;

import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 15.11.2020
 */
public interface UserRepository {


    List<User> getAll();

    List<User> getAllbyRestoranID(int id);

    boolean createUser(User user);

    boolean vote(User user, int restoranId);

    User getUser(int id);
}
