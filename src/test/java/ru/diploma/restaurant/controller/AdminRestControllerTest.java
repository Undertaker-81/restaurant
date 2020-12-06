package ru.diploma.restaurant.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.diploma.restaurant.*;

import ru.diploma.restaurant.controller.json.JsonUtil;
import ru.diploma.restaurant.model.Dish;
import ru.diploma.restaurant.model.Menu;
import ru.diploma.restaurant.model.Restaurant;
import ru.diploma.restaurant.repository.DishRepository;
import ru.diploma.restaurant.repository.MenuRepository;
import ru.diploma.restaurant.repository.RestaurantRepository;
import ru.diploma.restaurant.repository.UserRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.diploma.restaurant.TestUtil.*;


/**
 * @author Dmitriy Panfilov
 * 04.12.2020
 */

class AdminRestControllerTest extends AbstractControllerTest{

    private static final String REST_URL = AdminRestController.REST_URL + '/';

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private DishRepository dishRepository;



    @Test
    void menu() throws Exception {
        MvcResult action = perform(MockMvcRequestBuilders.get(REST_URL + "dish")
                .with(userHttpBasic(UserTestData.admin1)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andReturn();
         List<Dish>  menu = TestUtil.readListFromJsonMvcResult(action, Dish.class) ;
         Assertions.assertIterableEquals(menu, DishTestData.dishes);
    }

    @Test
    void createDish() throws Exception {
        Dish newDish = DishTestData.getNew();
        ResultActions action = perform(MockMvcRequestBuilders.post(REST_URL + "dish")
                .contentType(MediaType.APPLICATION_JSON)
                .with(userHttpBasic(UserTestData.admin1))
                .content(JsonUtil.writeValue(newDish)));

        Dish created = readFromJson(action, Dish.class);
        int newId = created.getId();
        newDish.setId(newId);
        assertEquals(newDish, created);
        assertEquals(dishRepository.findById(newId).get(), newDish);
    }

    @Test
    void createRestaurant() throws Exception {
        Restaurant newRestaurant = RestaurantTestData.getNew();
        ResultActions action = perform(MockMvcRequestBuilders.post(REST_URL + "restaurant")
                .contentType(MediaType.APPLICATION_JSON)
                 .with(userHttpBasic(UserTestData.admin1))
                .content(JsonUtil.writeValue(newRestaurant)));
        Restaurant created = readFromJson(action, Restaurant.class);
        int newId = created.getId();
        newRestaurant.setId(newId);
        assertEquals(newRestaurant, created);
        assertEquals(restaurantRepository.getRestaurant(newId), newRestaurant);
    }

    @Test
    void createMenu() throws Exception {
        List<Dish> menu = List.of(DishTestData.dish1, DishTestData.dish2, DishTestData.dish3, DishTestData.dish4);
        MvcResult action = perform(MockMvcRequestBuilders.post(REST_URL + "menu/{id}", RestaurantTestData.RESTAURANT1_ID)
                .contentType(MediaType.APPLICATION_JSON)
                 .with(userHttpBasic(UserTestData.admin1))
                .content(JsonUtil.writeValue(menu))).andReturn();
        List<Menu> created = readListFromJsonMvcResult(action, Menu.class);
        created.forEach(System.out::println);

    }
}