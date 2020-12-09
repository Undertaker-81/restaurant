package ru.diploma.restaurant.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.diploma.restaurant.DishTestData;
import ru.diploma.restaurant.model.Dish;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dmitriy Panfilov
 * 09.12.2020
 */
@SpringBootTest
class DishRepositoryTest {
    @Autowired
    private DishRepository repository;

    @Test
    void createDish() {
        Dish newDish = DishTestData.getNew();
        Dish created = repository.save(DishTestData.getNew());
        newDish.setId(created.getId());
        assertThat(created).isEqualTo(newDish);
        System.out.println(created);
    }

    @Test
    void getAll() {
        assertIterableEquals(repository.findAll(), DishTestData.dishes);
    }

    @Test
    void getDish() {
        assertEquals(repository.findById(DishTestData.DISH1_ID).get(), DishTestData.dish1);
    }
}