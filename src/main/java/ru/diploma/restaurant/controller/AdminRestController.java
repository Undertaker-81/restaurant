package ru.diploma.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.diploma.restaurant.model.Dish;
import ru.diploma.restaurant.model.Menu;
import ru.diploma.restaurant.model.Restaurant;
import ru.diploma.restaurant.repository.DishRepository;
import ru.diploma.restaurant.repository.MenuRepository;
import ru.diploma.restaurant.repository.RestaurantRepository;
import ru.diploma.restaurant.repository.UserRepository;

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

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dish")
    public List<Dish>  menu(){
        return dishRepository.getAlllDish();
    }

    @PostMapping(value = "/dish", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Dish createDish(@RequestBody Dish dish){
      return dishRepository.createDish(dish);
    }

    @PostMapping(value = "/restaurant", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant){
        //заглушка user
       return restaurantRepository.save(restaurant, userRepository.getUser(100001));
    }

    @PostMapping(value = "/menu/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Menu> createMenu(@PathVariable(value = "id") int restaurantId, @RequestBody List<Dish> menu){
       return menuRepository.createMenu(restaurantId, menu);
    }

    public int loginUserId (){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        String name = userDetail.getUsername();
        return userRepository.getUserByEmail(name).getId();
    }
}
