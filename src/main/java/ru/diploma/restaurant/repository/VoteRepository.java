package ru.diploma.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.diploma.restaurant.model.Vote;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 18.11.2020
 */
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    List<Vote> findAllByVoteDateAndRestaurantId(LocalDateTime dateTime, Integer id);

    List<Vote> findAllByVoteDate(LocalDateTime dateTime);




}
