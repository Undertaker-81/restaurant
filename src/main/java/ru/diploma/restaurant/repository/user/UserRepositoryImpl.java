package ru.diploma.restaurant.repository.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.diploma.restaurant.model.User;
import ru.diploma.restaurant.repository.UserRepository;

import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 15.11.2020
 */

@Transactional(readOnly = true)
@Service("userService")
public class UserRepositoryImpl implements UserRepository, UserDetailsService {
    @Autowired
    private CrudUserRepository userRepository;

       @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User createUser(User user) {
       if (user != null){
           return userRepository.save(user);
       }
        return null;
    }


    @Override
    public User getUser(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User getAdminByRestaurant(int idRestaurant) {
        return userRepository.getAdmin(idRestaurant);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
        }
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User myUser = userRepository.getUserByEmail(email.toLowerCase());
        if (myUser == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        UserDetails user = org.springframework.security.core.userdetails.User.builder()
                .username(myUser.getEmail())
                .password(myUser.getPassword())
                .roles(myUser.getRole().getAuthority())
                .build();
        return user;
    }
}
