package ru.diploma.restaurant.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.diploma.restaurant.DishTestData;
import ru.diploma.restaurant.RestaurantTestData;
import ru.diploma.restaurant.TestUtil;
import ru.diploma.restaurant.VoteTestData;
import ru.diploma.restaurant.controller.json.JsonUtil;
import ru.diploma.restaurant.model.Dish;
import ru.diploma.restaurant.model.Restaurant;
import ru.diploma.restaurant.model.Vote;
import ru.diploma.restaurant.repository.VoteRepository;
import ru.diploma.restaurant.to.RestaurantTo;
import ru.diploma.restaurant.util.UtilRestaurant;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.diploma.restaurant.DishTestData.*;
import static ru.diploma.restaurant.TestUtil.readFromJson;

/**
 * @author Dmitriy Panfilov
 * 05.12.2020
 */
class RestaurantRestControllerTest extends AbstractControllerTest{

    private static final String REST_URL = RestaurantRestController.REST_URL + '/';

    @Autowired
    private VoteRepository voteRepository;
    @Test
    void getAll() throws Exception {
        MvcResult action = perform(MockMvcRequestBuilders.get(REST_URL))
                // .with(userHttpBasic(user)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andReturn();
        List<Restaurant> restaurantList = TestUtil.readListFromJsonMvcResult(action, Restaurant.class) ;
        Assertions.assertIterableEquals(restaurantList, RestaurantTestData.restaurants);
    }

    @Test
    void voteCurrentDate() throws Exception {
        MvcResult action = perform(MockMvcRequestBuilders.get(REST_URL + "/vote")
                .queryParam("date", "2020-11-20"))
                // .with(userHttpBasic(user)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andReturn();

        List<RestaurantTo> votes = TestUtil.readListFromJsonMvcResult(action, RestaurantTo.class) ;
        Assertions.assertIterableEquals(votes, UtilRestaurant.getTos(VoteTestData.listAllOneDate, RestaurantTestData.restaurants));
    }

    @Test
    void getRestaurant() throws Exception {
        ResultActions action = perform(MockMvcRequestBuilders.get(REST_URL + "/{id}", RestaurantTestData.RESTAURANT1_ID))
                // .with(userHttpBasic(user)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
        Restaurant restaurant = TestUtil.readFromJson(action, Restaurant.class) ;
        Assertions.assertEquals(restaurant, RestaurantTestData.SOKOL);
    }

    @Test
    void voteRestaurantByDate() throws Exception {

        ResultActions action = perform(MockMvcRequestBuilders.get(REST_URL + "/vote/{id}", RestaurantTestData.RESTAURANT1_ID)
                .queryParam("date", "2020-11-20"))
                // .with(userHttpBasic(user)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
        RestaurantTo restaurant = TestUtil.readFromJson(action, RestaurantTo.class) ;
        Assertions.assertEquals(restaurant, DataAccessUtils.singleResult(UtilRestaurant.getTos(VoteTestData.list1, RestaurantTestData.restaurants)));
    }

    @Test
    void getMenuByRestaurant() throws Exception {
        MvcResult action = perform(MockMvcRequestBuilders.get(REST_URL + "/menu/{id}", RestaurantTestData.RESTAURANT1_ID)
                .queryParam("date", "2020-11-20"))
                // .with(userHttpBasic(user)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andReturn();
       List<Dish> menu = TestUtil.readListFromJsonMvcResult(action, Dish.class) ;
        List<Dish> dishList = List.of(dish1, dish4, dish6, dish8, dish9);
       Assertions.assertIterableEquals(menu, dishList);
    }

    @Test
    void createVote() throws Exception {
        Vote newVote = VoteTestData.getNew();
        ResultActions action = perform(MockMvcRequestBuilders.post(REST_URL + "/vote")
                .contentType(MediaType.APPLICATION_JSON)
                // .with(userHttpBasic(user))
                .content(JsonUtil.writeValue(newVote)));
        Vote created = readFromJson(action, Vote.class);
        int newId = created.getId();
        newVote.setId(newId);
        assertEquals(newVote, created);
        assertEquals(voteRepository.getOne(newId), newVote);
    }
}