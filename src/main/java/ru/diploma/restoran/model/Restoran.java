package ru.diploma.restoran.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "restorans")
public class Restoran {
    public static final int START_SEQ = 100000;
    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private int id;

    @NotNull
    private String name;
    @ManyToMany
    @JoinTable(
            name="restorans_dish",
            joinColumns=@JoinColumn(name="RESTORAN_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="DISH_ID", referencedColumnName="ID"))
    private Set<Dish> menu;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    @ManyToMany
    @JoinTable(
            name="restorans_users",
            joinColumns=@JoinColumn(name="RESTORAN_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="USER_ID", referencedColumnName="ID"))
    private List<User> users;
}
