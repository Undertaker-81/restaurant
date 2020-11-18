package ru.diploma.restoran.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.diploma.restoran.model.User;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Panfilov Dmitriy
 * 12.11.2020
 */
public interface CrudUserRepository extends JpaRepository<User, Integer> {

//    @Query("select u from User u join fetch u.restorans restoran where restoran.id=:id")
//    List<User> findAllByRestorans(@Param("id") int id);
    @Query("select u from User u inner join Restoran r where r.user.id=:id and r.id=:restoran_id")
    User getAdmin(@Param("id") int id, @Param("restran_id") int idRestoran);
}
