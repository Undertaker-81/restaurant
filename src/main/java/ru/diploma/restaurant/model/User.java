package ru.diploma.restaurant.model;

import lombok.*;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity implements Serializable {


    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;


    @Enumerated(EnumType.STRING)
    private Role role;

    public User(Integer id, @NotNull String name,  @NotNull @Email String email, @NotNull String password, Role role) {
        super(id);
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}
