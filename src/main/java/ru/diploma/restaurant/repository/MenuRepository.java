package ru.diploma.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.diploma.restaurant.model.Dish;
import ru.diploma.restaurant.model.Menu;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 18.11.2020
 */
@Transactional(readOnly = true)
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    List<Menu> getAllByDateMenuAndRestaurantId(@NotNull LocalDate dateMenu, @NotNull int restaurantId);

   // List<Menu>   createMenu(int restaurantId, List<Dish> menu);

}
