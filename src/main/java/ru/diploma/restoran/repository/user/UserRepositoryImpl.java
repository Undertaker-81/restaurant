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
    public User createUser(User user) {
       if (user != null){
           return userRepository.save(user);
       }
        return null;
    }


    @Override
    public User getUser(int id) {
        return userRepository.getOne(id);
    }

    @Override
    public User getAdminByRestoran(int id, int idRestoran) {
        return userRepository.getAdmin(id, idRestoran);
    }

    @Override
    public void deleteUser(int id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
        }
    }
}
