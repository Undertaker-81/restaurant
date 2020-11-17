package ru.diploma.restoran.repository.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.diploma.restoran.model.User;
import ru.diploma.restoran.repository.UserRepository;

import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 15.11.2020
 */
@Repository
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private CrudUserRepository userRepository;

       @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllbyRestoranID(int id) {
        return userRepository.findAllByRestorans(id);
    }

    @Override
    public boolean createUser(User user) {
        return false;
    }

    @Override
    @Transactional
    public boolean vote(User user, int retoran_id) {

        return false;
    }

    @Override
    public User getUser(int id) {
        return null;
    }
}
