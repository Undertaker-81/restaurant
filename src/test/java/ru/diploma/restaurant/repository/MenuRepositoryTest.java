package ru.diploma.restaurant.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.diploma.restaurant.DishTestData;
import ru.diploma.restaurant.MenuTestData;
import ru.diploma.restaurant.RestaurantTestData;
import ru.diploma.restaurant.model.Dish;
import ru.diploma.restaurant.model.Menu;
import ru.diploma.restaurant.service.MenuService;

import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static java.time.LocalDate.of;
/**
 * @author Dmitriy Panfilov
 * 09.12.2020
 */
@SpringBootTest
class MenuRepositoryTest {

    @Autowired
    private MenuService repository;

    @Test
    void getAllByDateMenuAndRestaurantId() {
        assertIterableEquals(repository.getAllbyDateAndRestaurant(RestaurantTestData.RESTAURANT1_ID, of(2020, Month.NOVEMBER, 20)),
                MenuTestData.SOKOL_MENU);

        System.out.println(repository.getAllbyDateAndRestaurant(RestaurantTestData.RESTAURANT1_ID, of(2020, Month.NOVEMBER, 20)));
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