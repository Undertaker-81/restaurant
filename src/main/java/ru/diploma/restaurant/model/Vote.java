package ru.diploma.restaurant.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Panfilov Dmitriy
 * 18.11.2020
 */
@Getter
@Setter
@Entity
@Table(name = "vote")
@NoArgsConstructor
public class Vote extends BaseEntity  {

    @Column(name = "restaurant_id", nullable = false)
    @NotNull
    private int idRestaurant;

    @Column(name = "user_id", nullable = false)
    @NotNull
    private int idUser;

    @Column(name = "date", nullable = false)
    @NotNull
    private LocalDateTime dateVote;
}

