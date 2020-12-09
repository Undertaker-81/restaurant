package ru.diploma.restaurant.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Panfilov Dmitriy
 * 18.11.2020
 */
@Getter
@Setter
@Entity
@Table(name = "vote")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Vote extends BaseEntity  {

    @Column(name = "restaurant_id", nullable = false)
    @NotNull
    private int restaurantId;

    @Column(name = "user_id", nullable = false)
    @NotNull
    private int userId;

    @Column(name = "vote_date", nullable = false)
    @NotNull
    private LocalDate voteDate;

    public Vote(Integer id, @NotNull int userId, @NotNull int restaurantId,  @NotNull LocalDate voteDate) {
        super(id);
        this.restaurantId = restaurantId;
        this.userId = userId;
        this.voteDate = voteDate;
    }
}

