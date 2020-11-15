package ru.diploma.restoran.repository.restoran;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.diploma.restoran.model.Restoran;
import ru.diploma.restoran.repository.RestoramRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 15.11.2020
 */
@Repository
public class RestoranRepositoryImpl implements RestoramRepository {
    @Autowired
    private CrudRestoranRepository repository;

    @Override
    public List<Restoran> allRestoransByDate(LocalDate date) {
        return repository.getAll();
    }

    @Override
    public Restoran getRestoran(int id) {
        return null;
    }

    @Override
    public int countVoteByRestoran(int restoranId, LocalDate date) {
        return 0;
    }

    @Override
    public void vote(int restoranId, int userId, LocalDateTime date) {

    }
}
