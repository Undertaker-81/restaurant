package ru.diploma.restoran.repository.restoran;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.diploma.restoran.model.Restoran;
import ru.diploma.restoran.model.User;
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
    public List<Restoran> allRestorans() {
        return repository.getAll();
    }

    @Override
    public Restoran getRestoran(int id) {
        return repository.getRestoransById(id);
    }

    @Override
    public User getAdmin(int id) {
        return repository.getAdmin(id);
    }

    @Override
    public void delete(int id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
        }
    }

    @Override
    public Restoran save(Restoran restoran, User user) {
        if (restoran.getId() == null){
            restoran.setUser(user);
            repository.save(restoran);
        }
        return repository.save(restoran);
    }



}
