package ru.diploma.restaurant.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.springframework.data.domain.Persistable;
import ru.diploma.restaurant.util.JsonDeserializers;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
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


    @NotEmpty

    private String name;


    @NotEmpty
    @Email
    @Column(unique=true)
    private String email;

    @NotEmpty
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonDeserialize(using = JsonDeserializers.PasswordDeserializer.class)
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
