package ru.diploma.restaurant.model;


import lombok.Getter;

import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Panfilov Dmitriy
 * 18.11.2020
 */
@Getter
@Setter
@Entity
@Table(name = "VOTE")
public class Vote {

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = Restaurant.START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private Integer id;

    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    private int idUser;

    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
    private int idRestaurant;


    @JoinColumn(name = "date", nullable = false)
    @NotNull
    private LocalDateTime dateVote;

    public Vote(Integer id,  @NotNull int idUser, @NotNull int idRestaurant,@NotNull LocalDateTime dateVote) {
        this.id = id;
        this.idRestaurant = idRestaurant;
        this.idUser = idUser;
        this.dateVote = dateVote;
    }

    public Vote() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(int idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public LocalDateTime getDateVote() {
        return dateVote;
    }

    public void setDateVote(LocalDateTime dateVote) {
        this.dateVote = dateVote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return Objects.equals(id, vote.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
