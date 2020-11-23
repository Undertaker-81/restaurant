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
@Table(name = "vote")
public class Vote {

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = Restaurant.START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private Integer id;

    @Column(name = "user_id", nullable = false)
    @NotNull
    private int userId;

    @Column(name = "restaurant_id", nullable = false)
    @NotNull
    private int restaurantId;


    @Column(name = "vote_date", nullable = false)
    @NotNull
    private LocalDateTime voteDate;

    public Vote(Integer id,  @NotNull int idUser, @NotNull int idRestaurant,@NotNull LocalDateTime voteDate) {
        this.id = id;
        this.restaurantId = idRestaurant;
        this.userId = idUser;
        this.voteDate = voteDate;
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
        return restaurantId;
    }

    public void setIdRestaurant(int idRestaurant) {
        this.restaurantId = idRestaurant;
    }

    public int getIdUser() {
        return userId;
    }

    public void setIdUser(int idUser) {
        this.userId = idUser;
    }

    public LocalDateTime getDateVote() {
        return voteDate;
    }

    public void setDateVote(LocalDateTime dateVote) {
        this.voteDate = dateVote;
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
