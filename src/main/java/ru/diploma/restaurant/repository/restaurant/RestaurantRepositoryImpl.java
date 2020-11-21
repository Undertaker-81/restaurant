package ru.diploma.restaurant.repository.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.diploma.restaurant.model.Restaurant;
import ru.diploma.restaurant.model.User;
import ru.diploma.restaurant.repository.RestaurantRepository;


import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 15.11.2020
 */
@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @Autowired
    private CrudRestaurantRepository repository;

    @Override
    public List<Restaurant> allRestaurant() {
        return repository.getAll();
    }

    @Override
    public Restaurant getRestaurant(int id) {
        return repository.getRestaurantById(id);
    }

    @Override
    public User getAdmin(int id) {
        return repository.getAdmin(id);
    }

    @Override
    public void delete(int id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
        }
    }

    @Override
    public Restaurant save(Restaurant restaurant, User user) {
        if (restaurant.getId() == null){
            restaurant.setUser(user);
            repository.save(restaurant);
        }
        return repository.save(restaurant);
    }



}
