package ru.diploma.restaurant.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import ru.diploma.restaurant.model.User;
import ru.diploma.restaurant.repository.UserRepository;


import java.util.List;


/**
 * @author Dmitriy Panfilov
 * 23.11.2020
 */
@RestController
@RequestMapping( produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController {

    static final String REST_URL = "/user";

    @Autowired
    private UserRepository userRepository;


    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User create(@RequestBody User user){
        return userRepository.save(user);
    }
    @GetMapping(REST_URL)
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @GetMapping(REST_URL + "/{id}")
    public User getUser(@PathVariable int id){

        return userRepository.findById(id).orElseThrow();
    }

    @DeleteMapping(REST_URL + "/{id}")
    public void delete(@PathVariable int id) throws HttpRequestMethodNotSupportedException {
        if (loginUserId() == id){
            userRepository.deleteById(id);
        }else throw new HttpRequestMethodNotSupportedException("");

    }

    public int loginUserId (){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        String name = userDetail.getUsername();
        return userRepository.getUserByEmail(name).getId();
    }
}