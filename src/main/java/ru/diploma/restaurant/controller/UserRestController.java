package ru.diploma.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.diploma.restaurant.model.User;
import ru.diploma.restaurant.repository.UserRepository;

import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 23.11.2020
 */
@RestController
@RequestMapping(value = UserRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController {

    static final String REST_URL = "/user";

    @Autowired
    private UserRepository userRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public User create(@RequestBody User user){
        return userRepository.createUser(user);
    }
    @GetMapping
    public List<User> getAll(){
       return userRepository.getAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id){
       return userRepository.getUser(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        userRepository.deleteUser(id);
    }
}
