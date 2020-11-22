package ru.diploma.restaurant.repository.dish;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.diploma.restaurant.DishTestData;
import ru.diploma.restaurant.model.Dish;
import ru.diploma.restaurant.repository.AbstractRepositoryTest;
import ru.diploma.restaurant.repository.DishRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dmitriy Panfilov
 * 21.11.2020
 */
class DishRepositoryImplTest extends AbstractRepositoryTest {

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