package ru.diploma.restoran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diploma.restoran.model.Vote;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 18.11.2020
 */
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    List<Vote> findAllByDateVoteAndIdRestoran(LocalDateTime dateTime, Integer id);

}
