package ru.diploma.restaurant.repository.restaurant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.diploma.restaurant.DishTestData;
import ru.diploma.restaurant.RestaurantTestData;
import ru.diploma.restaurant.UserTestData;
import ru.diploma.restaurant.model.Restaurant;
import ru.diploma.restaurant.model.User;
import ru.diploma.restaurant.repository.AbstractRepositoryTest;
import ru.diploma.restaurant.repository.RestaurantRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dmitriy Panfilov
 * 22.11.2020
 */
class RestaurantRepositoryImplTest extends AbstractRepositoryTest {

    @Autowired
    private RestaurantRepository repository;

    @Test
    void allRestaurant() {
        assertIterableEquals(repository.allRestaurant(), RestaurantTestData.restaurants);
        repository.allRestaurant().forEach(System.out::println);
    }

    @Test
    void getRestaurant() {
        assertEquals(repository.getRestaurant(RestaurantTestData.RESTAURANT1_ID), RestaurantTestData.SOKOL);
    }

    @Test
    void getAdmin() {
        User admin = repository.getAdmin(RestaurantTestData.RESTAURANT1_ID);
        assertEquals(admin, UserTestData.admin1);
    }

    @Test
    void delete() {
        repository.delete(RestaurantTestData.RESTAURANT1_ID ,UserTestData.ADMIN1_ID);
        assertNull( repository.getRestaurant(RestaurantTestData.RESTAURANT1_ID));
    }

    @Test
    void save() {
        Restaurant newRestaurant = RestaurantTestData.getNew();
        Restaurant created = repository.save(newRestaurant, UserTestData.admin1);
        newRestaurant.setId(created.getId());
        assertThat(created).isEqualTo(newRestaurant);
        System.out.println(created);
    }
}