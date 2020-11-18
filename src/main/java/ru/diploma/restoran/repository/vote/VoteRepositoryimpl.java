package ru.diploma.restoran.repository.vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.diploma.restoran.model.Vote;
import ru.diploma.restoran.repository.VoteRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 18.11.2020
 */
@Repository
public class VoteRepositoryimpl {

    @Autowired
    private VoteRepository repository;

    public Vote save(Vote vote){
        return repository.save(vote);
    }

    public List<Vote> getAllByDate(LocalDateTime dateTime, Integer restoranId){
        return repository.findAllByDateVoteAndIdRestoran(dateTime, restoranId);
    }
}
