package ru.diploma.restoran.repository;

import ru.diploma.restoran.model.Restoran;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Panfilov Dmitriy
 * 12.11.2020
 */
public interface RestoramRepository {

    List<Restoran> allRestoransByDate(LocalDate date);

    Restoran getRestoran(int id);

    int countVoteByRestoran(int restoranId, LocalDate date);

    void vote(int restoranId, int userId, LocalDateTime date);
}
