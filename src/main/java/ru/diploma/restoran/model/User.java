package ru.diploma.restoran.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="users")
public class User {
    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = Restoran.START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private int id;

    @NotNull
    private String name;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role"}, name = "user_roles_unique_idx")})
    @Column(name = "role")
    private Role role;

    @ManyToMany
    @JoinTable(
            name="restorans_users",
            joinColumns=@JoinColumn(name="USER_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="RESTORAN_ID", referencedColumnName="ID"))
    private List<Restoran> restorans;
}
