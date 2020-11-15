package ru.diploma.restoran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.diploma.restoran.model.Dish;
import ru.diploma.restoran.model.Restoran;
import ru.diploma.restoran.model.User;
import ru.diploma.restoran.repository.DishRepository;
import ru.diploma.restoran.repository.RestoramRepository;
import ru.diploma.restoran.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 15.11.2020
 */
@Controller
public class RestController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestoramRepository restoramRepository;

    public List<User> getAll(){
        return userRepository.getAll();

    }

    public List<User> getAllByRestoran(int id){
        return userRepository.getAllbyRestoranID(id);
    }
}
