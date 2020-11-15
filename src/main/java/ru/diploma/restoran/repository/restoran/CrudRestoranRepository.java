package ru.diploma.restoran.repository.restoran;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.diploma.restoran.model.Restoran;
import ru.diploma.restoran.model.User;


import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudRestoranRepository extends JpaRepository<Restoran, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Restoran m WHERE m.id=:id AND m.user.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);

    @Query("select r from Restoran  r")
    List<Restoran> getAll();

    Restoran getRestoransById(int id);


}