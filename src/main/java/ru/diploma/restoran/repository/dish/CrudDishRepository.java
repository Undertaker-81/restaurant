package ru.diploma.restoran.repository.dish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.diploma.restoran.model.Dish;


import java.util.List;

/**
 * @author Panfilov Dmitriy
 * 12.11.2020
 */
@Transactional(readOnly = true)
public interface CrudDishRepository extends JpaRepository<Dish, Integer> {

}
