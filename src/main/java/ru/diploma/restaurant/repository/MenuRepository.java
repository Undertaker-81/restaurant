package ru.diploma.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diploma.restaurant.model.Menu;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 18.11.2020
 */
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    List<Menu> getAllByDateMenuAndIdRestaurant(@NotNull LocalDate dateMenu, @NotNull int idRestaurant);


}
