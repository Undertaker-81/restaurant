package ru.diploma.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.diploma.restaurant.model.Vote;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 18.11.2020
 */
@Transactional(readOnly = true)
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    List<Vote> findAllByVoteDateAndRestaurantId(LocalDate dateTime, Integer id);

    List<Vote> findAllByVoteDate(LocalDate dateTime);
}