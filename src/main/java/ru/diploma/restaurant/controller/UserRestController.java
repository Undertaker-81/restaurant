package ru.diploma.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import ru.diploma.restaurant.model.User;
import ru.diploma.restaurant.repository.UserRepository;
import ru.diploma.restaurant.repository.user.UserRepositoryImpl;

import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 23.11.2020
 */
@RestController
@RequestMapping( produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController {

    static final String REST_URL = "/user";


    @Qualifier("userService")
    @Autowired
    private UserRepository userRepository;


    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User create(@RequestBody User user){
        return userRepository.createUser(user);
    }
    @GetMapping(REST_URL)
    public List<User> getAll(){
       return userRepository.getAll();
    }

    @GetMapping(REST_URL + "/{id}")
    public User getUser(@PathVariable int id){

       return userRepository.getUser(id);
    }

    @DeleteMapping(REST_URL + "/{id}")
    public void delete(@PathVariable int id) throws HttpRequestMethodNotSupportedException {
        if (loginUserId() == id){
            userRepository.deleteUser(id);
        }else throw new HttpRequestMethodNotSupportedException("");

    }

    public int loginUserId (){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        String name = userDetail.getUsername();
        return userRepository.getUserByEmail(name).getId();
    }
}
