package ru.diploma.restaurant.repository.menu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.diploma.restaurant.repository.AbstractRepositoryTest;
import ru.diploma.restaurant.repository.MenuRepository;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dmitriy Panfilov
 * 22.11.2020
 */
class MenuRepositoryImplTest extends AbstractRepositoryTest {

    @Autowired
    private MenuRepository repository;

    @Test
    void getAllbyDateAndRestaurant() {
        repository.findAll();
    }

    @Test
    void createMenu() {
    }
}