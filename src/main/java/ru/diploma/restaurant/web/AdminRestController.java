package ru.diploma.restaurant.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import ru.diploma.restaurant.AuthUser;
import ru.diploma.restaurant.model.Dish;
import ru.diploma.restaurant.model.Menu;
import ru.diploma.restaurant.model.Restaurant;
import ru.diploma.restaurant.repository.DishRepository;
import ru.diploma.restaurant.repository.RestaurantRepository;
import ru.diploma.restaurant.repository.UserRepository;
import ru.diploma.restaurant.service.MenuService;


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
    private MenuService menuService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dish")
    public List<Dish>  menu(){
        return dishRepository.findAll();
    }

    @PostMapping(value = "/dish", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Dish createDish(@RequestBody Dish dish){
        return dishRepository.save(dish);
    }

    @PostMapping(value = "/restaurant", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant, @AuthenticationPrincipal AuthUser authUser){
        //залогиненый админ
        restaurant.setUser(userRepository.getOne(authUser.id()));
        return restaurantRepository.save(restaurant );
    }

    @PostMapping(value = "/menu/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Menu> createMenu(@PathVariable(value = "id") int restaurantId, @RequestBody List<Dish> menu, @AuthenticationPrincipal AuthUser authUser) throws HttpRequestMethodNotSupportedException {
        if (authUser.id() == restaurantRepository.getByUser(restaurantId).getId()){
            return menuService.createMenu(restaurantId, menu);
        } else throw new HttpRequestMethodNotSupportedException("");

    }
/*
    public int loginUserId (){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        String name = userDetail.getUsername();
        return userRepository.getUserByEmail(name).getId();
    }

 */
}
