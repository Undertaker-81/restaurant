package ru.diploma.restoran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.diploma.restoran.model.Restoran;


import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudMealRepository extends JpaRepository<Restoran, Integer> {
//TODO тут все не правильно
    @Modifying
    @Transactional
    @Query("DELETE FROM Restoran m WHERE m.id=:id AND m.user.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);

    @Query("SELECT m FROM Restoran m WHERE m.user.id=:userId ORDER BY m.dateTime DESC")
    List<Restoran> getAll(@Param("userId") int userId);

    @Query("SELECT m from Restoran m WHERE m.user.id=:userId AND m.dateTime >= :startDate AND m.dateTime < :endDate ORDER BY m.dateTime DESC")
    List<Restoran> getBetweenHalfOpen(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("userId") int userId);

    @Query("SELECT m FROM Restoran m JOIN FETCH m.user WHERE m.id = ?1 and m.user.id = ?2")
    Restoran getWithUser(int id, int userId);
}