package ru.diploma.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diploma.restaurant.model.Menu;

/**
 * @author Dmitriy Panfilov
 * 18.11.2020
 */
public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
