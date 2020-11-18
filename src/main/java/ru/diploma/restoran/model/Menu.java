package ru.diploma.restoran.model;

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
public class Menu {
    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = Restoran.START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private int id;

    @JoinColumn(name = "restoran_id", nullable = false)
    @NotNull
    private int idRestoran;

    @JoinColumn(name = "dish_id", nullable = false)
    @NotNull
    private int idDish;

    @JoinColumn(name = "date", nullable = false)
    @NotNull
    private LocalDateTime dateMenu;
}
