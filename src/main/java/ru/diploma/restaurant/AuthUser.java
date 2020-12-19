package ru.diploma.restaurant;


import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.NonNull;
import ru.diploma.restaurant.model.User;

import java.util.Set;

/**
 * @author Dmitriy Panfilov
 * 19.12.2020
 */

@Getter
@ToString(of = "user")
public class AuthUser extends org.springframework.security.core.userdetails.User {

    private final User user;

    public AuthUser(@NonNull User user) {
        super(user.getEmail(), user.getPassword(), Set.of(user.getRole()));
        this.user = user;
    }

    public int id() {
        return user.id();
    }
}
