package ru.diploma.restaurant.util;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.diploma.restaurant.to.RestaurantTo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * @author Dmitriy Panfilov
 * 10.01.2021
 */
@Component
public class RestaurantMapper implements RowMapper<RestaurantTo> {
    @Override
    public RestaurantTo mapRow(ResultSet resultSet, int i) throws SQLException {
        RestaurantTo restaurantTo = new RestaurantTo();
        restaurantTo.setName(resultSet.getString("name"));
        restaurantTo.setDate(LocalDate.parse(resultSet.getString("vote_date")));
        restaurantTo.setVoteCount(resultSet.getInt("votes"));
        return restaurantTo;
    }
}
