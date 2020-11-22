package ru.diploma.restaurant.repository;

import ru.diploma.restaurant.model.Restaurant;
import ru.diploma.restaurant.model.User;

import java.util.List;

/**
 * @author Panfilov Dmitriy
 * 12.11.2020
 */
public interface RestaurantRepository {

    List<Restaurant> allRestaurant();

    Restaurant getRestaurant(int id);

    User getAdmin(int id);

    void delete(int id, int adminId);

    Restaurant save(Restaurant restaurant, User user);
}
