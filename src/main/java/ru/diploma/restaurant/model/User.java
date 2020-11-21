package ru.diploma.restaurant.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="users")
public class User {
    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = Restaurant.START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private int id;

    @NotNull
    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;



  /*  @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="restorans_users",
            joinColumns=@JoinColumn(name="USER_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="RESTORAN_ID", referencedColumnName="ID"))
    private List<restaurant> restorans;

   */



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
            //    ", restorans=" + restorans +
                '}';
    }
}
