package ru.diploma.restaurant.repository.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.diploma.restaurant.model.Restaurant;
import ru.diploma.restaurant.model.User;


import java.util.List;

@Transactional(readOnly = true)
public interface CrudRestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Restaurant m WHERE m.id=:id AND m.user.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);



    Restaurant getRestaurantById(int id);

    @Query("select r.user from Restaurant r where r.id=:id")
    User getAdmin(@Param("id") int id);
}