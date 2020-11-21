package ru.diploma.restaurant.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "restaurant")
public class Restaurant {
    public static final int START_SEQ = 100000;
    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private Integer id;

    @NotNull
    private String name;
    /*
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="restorans_dish",
            joinColumns=@JoinColumn(name="RESTORAN_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="DISH_ID", referencedColumnName="ID"))
    private List<Dish> menu;

     */

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;
/*
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="restorans_users",
            joinColumns=@JoinColumn(name="RESTORAN_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="USER_ID", referencedColumnName="ID"))
    private List<User> users;

 */

    public Integer getId() {
        return id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant restaurant = (Restaurant) o;
        return id == restaurant.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
        //        ", user=" + user +
                '}';
    }
}
