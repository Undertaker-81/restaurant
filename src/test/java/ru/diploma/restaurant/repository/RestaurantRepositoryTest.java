package ru.diploma.restaurant.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.diploma.restaurant.RestaurantTestData;
import ru.diploma.restaurant.UserTestData;
import ru.diploma.restaurant.model.Restaurant;
import ru.diploma.restaurant.model.User;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Dmitriy Panfilov
 * 09.12.2020
 */
@SpringBootTest
class RestaurantRepositoryTest {

    @Autowired
    private RestaurantRepository repository;

    @Test
    void allRestaurant() {
        assertIterableEquals(repository.findAll(), RestaurantTestData.restaurants);
        repository.findAll().forEach(System.out::println);
    }

    @Test
    void getRestaurant() {
        assertEquals(repository.findById(RestaurantTestData.RESTAURANT1_ID).get(), RestaurantTestData.SOKOL);
    }

    @Test
    void getAdmin() {
        User admin = repository.getByUser(RestaurantTestData.RESTAURANT1_ID);
        assertEquals(admin, UserTestData.admin1);
    }

    @Test
    void delete() {
        repository.deleteById(RestaurantTestData.RESTAURANT1_ID);
        assertTrue( repository.findById(RestaurantTestData.RESTAURANT1_ID).isEmpty());

    }

    @Test
    void save() {
        Restaurant newRestaurant = RestaurantTestData.getNew();
        Restaurant created = repository.save(newRestaurant);
        newRestaurant.setId(created.getId());
        assertThat(created).isEqualTo(newRestaurant);
        System.out.println(created);
    }
}