package ru.diploma.restaurant.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.diploma.restaurant.to.RestaurantTo;
import ru.diploma.restaurant.util.RestaurantMapper;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 10.01.2021
 */
@Repository
public class RestaurantToRepository {
    private static final String SQLQuery = "select R.NAME, VOTE_DATE, count(VOTE.USER_ID) as votes from VOTE\n" +
            "inner join RESTAURANT R on R.ID = VOTE.RESTAURANT_ID\n" +
            "where VOTE_DATE=:dateTime group by  RESTAURANT_ID";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private RestaurantMapper mapper;




    public List<RestaurantTo> getVotes( LocalDate dateTime){
         SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("dateTime", dateTime);
       return jdbcTemplate.query(SQLQuery, sqlParameterSource, mapper);

    }
}
