package ru.diploma.restaurant.repository.menu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.diploma.restaurant.DishTestData;
import ru.diploma.restaurant.MenuTestData;
import ru.diploma.restaurant.RestaurantTestData;
import ru.diploma.restaurant.model.Dish;
import ru.diploma.restaurant.model.Menu;
import ru.diploma.restaurant.repository.AbstractRepositoryTest;
import ru.diploma.restaurant.repository.MenuRepository;

import java.time.Month;
import java.util.List;

import static java.time.LocalDate.of;
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
        assertIterableEquals(repository.getAllByDateMenuAndIdRestaurant(of(2020, Month.NOVEMBER, 20), RestaurantTestData.RESTAURANT1_ID),
                MenuTestData.SOKOL_MENU);
    }

    @Test
    void createMenu() {
        Menu newMenu1 = MenuTestData.getNew1();
        Menu newMenu2 = MenuTestData.getNew2();
        Menu newMenu3 = MenuTestData.getNew3();
        List<Dish> menu = List.of(DishTestData.dish2, DishTestData.dish3, DishTestData.dish4);
        List <Menu> menuList = repository.createMenu(RestaurantTestData.RESTAURANT1_ID, menu);
        menuList.forEach(System.out::println);
    }
}