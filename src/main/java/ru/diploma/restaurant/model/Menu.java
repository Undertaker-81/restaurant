package ru.diploma.restaurant.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author Panfilov Dmitriy
 * 18.11.2020
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "menu")
public class Menu extends BaseEntity  {

    @NotNull
    @Column(name = "restaurant_id", nullable = false)
    private int idRestoran;

    @NotNull
    @Column(name = "dish_id", nullable = false)
    private int idDish;

    @Column(name = "date", nullable = false)
    @NotNull
    private LocalDateTime dateMenu;
}

