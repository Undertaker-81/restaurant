package ru.diploma.restaurant.repository;

import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author Dmitriy Panfilov
 * 21.11.2020
 */
@SpringJUnitConfig(locations = {
        "classpath:spring/spring-db.xml"
})

@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public abstract class AbstractRepositoryTest {
}
