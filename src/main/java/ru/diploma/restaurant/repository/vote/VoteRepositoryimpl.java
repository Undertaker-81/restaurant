package ru.diploma.restaurant.repository.vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.diploma.restaurant.model.Vote;
import ru.diploma.restaurant.repository.VoteRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 18.11.2020
 */
@Repository
@Transactional(readOnly = true)
public class VoteRepositoryimpl {

    @Autowired
    private VoteRepository repository;

    @Transactional
    public Vote save(Vote vote){
        return repository.save(vote);
    }

    public List<Vote> getAllByDateAndRestaurant(LocalDateTime date, Integer restaurantId){
        return repository.findAllByDateVoteAndIdRestaurant(date, restaurantId);
    }

    public List<Vote> getAllbyDate(LocalDateTime dateTime){
        return repository.findAllByDateVote(dateTime);
    }

    public List<Vote> getAll(){
        return repository.getAllBy();
    }


}
