package ru.diploma.restoran.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Entity
@Table(name = "restorans")
public class Restoran {
    public static final int START_SEQ = 100000;
    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    @Getter
    @Setter
    private int id;

    @NotNull
    @Getter
    @Setter
    private String name;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="restorans_dish",
            joinColumns=@JoinColumn(name="RESTORAN_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="DISH_ID", referencedColumnName="ID"))
    @Getter
    @Setter
    private List<Dish> menu;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    @Getter
    @Setter
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="restorans_users",
            joinColumns=@JoinColumn(name="RESTORAN_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="USER_ID", referencedColumnName="ID"))
    @Getter
    @Setter
    private List<User> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restoran restoran = (Restoran) o;
        return id == restoran.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Restoran{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", menu=" + menu +
                ", user=" + user +
                ", users=" + users +
                '}';
    }
}
