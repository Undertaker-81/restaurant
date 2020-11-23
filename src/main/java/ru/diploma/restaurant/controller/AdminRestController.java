package ru.diploma.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.diploma.restaurant.model.Dish;
import ru.diploma.restaurant.model.Restaurant;
import ru.diploma.restaurant.repository.DishRepository;
import ru.diploma.restaurant.repository.MenuRepository;
import ru.diploma.restaurant.repository.RestaurantRepository;

import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 23.11.2020
 */
@RestController
@RequestMapping(value = AdminRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestController {
    static final String REST_URL = "/admin";

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping("/dish")
    public List<Dish>  menu(){
        return dishRepository.getAlllDish();
    }

    public void createDish(Dish dish){
       //TODO
    }

    public void createRestaurant(Restaurant restaurant){
        //TODO
    }

    public void createMenu(int restaurantId, List<Dish> menu){
        //TODO
    }
}
