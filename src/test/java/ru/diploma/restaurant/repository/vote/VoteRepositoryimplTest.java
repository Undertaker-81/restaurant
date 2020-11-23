package ru.diploma.restaurant.repository.vote;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.diploma.restaurant.DishTestData;
import ru.diploma.restaurant.RestaurantTestData;
import ru.diploma.restaurant.VoteTestData;
import ru.diploma.restaurant.model.Dish;
import ru.diploma.restaurant.model.Vote;
import ru.diploma.restaurant.repository.AbstractRepositoryTest;
import ru.diploma.restaurant.repository.VoteRepository;

import java.time.Month;

import static java.time.LocalDate.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dmitriy Panfilov
 * 22.11.2020
 */
class VoteRepositoryimplTest extends AbstractRepositoryTest {

    @Autowired
    private VoteRepository repository;

    @Test
    void save() {
        Vote newVote = VoteTestData.getNew();
        Vote created = repository.save(VoteTestData.getNew());
        newVote.setId(created.getId());
        assertThat(created).isEqualTo(newVote);
        System.out.println(created);
    }

    @Test
    void getAllByDateAndRestaurantId() {
        assertIterableEquals(repository.findAllByVoteDateAndRestaurantId(of(2020, Month.NOVEMBER, 20), RestaurantTestData.RESTAURANT1_ID),
                                VoteTestData.list1);
    }

    @Test
    void getAllbyDate() {
        assertIterableEquals(repository.findAllByVoteDate(of(2020, Month.NOVEMBER, 20)), VoteTestData.listAllOneDate);
    }

    @Test
    void getAll() {
        assertIterableEquals(repository.findAll(), VoteTestData.listAll);
    }
}