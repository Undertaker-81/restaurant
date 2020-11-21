package ru.diploma.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.diploma.restaurant.model.Restaurant;
import ru.diploma.restaurant.model.User;
import ru.diploma.restaurant.repository.RestaurantRepository;
import ru.diploma.restaurant.repository.UserRepository;

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
    private RestaurantRepository restaurantRepository;

    public List<User> getAll(){
        return userRepository.getAll();

    }

    public Restaurant getRestaurant(int id){
       return restaurantRepository.getRestaurant(id);
    }

}
