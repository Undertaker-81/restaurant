package ru.diploma.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.diploma.restaurant.model.Restaurant;
import ru.diploma.restaurant.model.User;

import java.util.List;

/**
 * @author Panfilov Dmitriy
 * 12.11.2020
 */
@Transactional(readOnly = true)
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {


    @Query("select r.user from Restaurant r where r.id=:restaurantId")
    User getByUser(int restaurantId);

}
